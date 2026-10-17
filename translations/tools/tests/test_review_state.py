import importlib.util
import json
import tempfile
import unittest
from pathlib import Path

SPEC = importlib.util.spec_from_file_location("review_state", Path(__file__).resolve().parents[1] / "Review-State.py")
review = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(review)


class ReviewInvalidationTest(unittest.TestCase):
    def setUp(self):
        self.storage = tempfile.TemporaryDirectory(prefix="myinsta-review-state-")
        self.repository = Path(self.storage.name).resolve()
        self.repository.relative_to(Path(tempfile.gettempdir()).resolve())
        self.source = {"strings": {"example": "Read {name}", "other": "Close"}, "plurals": {}}
        self.context = {"entries": {"example": {"meaning": "local reading"}, "other": {"meaning": "close"}}}
        self.state = {
            "sourceEntries": {key: {"kind": "strings", "textSha256": review.digest(value),
                                      "contextSha256": review.digest(self.context["entries"][key])}
                              for key, value in self.source["strings"].items()},
            "locales": {locale: {"entries": {key: {"targetSha256": review.digest(value)}
                                                for key, value in self.source["strings"].items()}}
                        for locale in ("en", "example-locale")},
        }
        for locale in ("en", "example-locale"):
            self.write(locale, self.source)
        self.write("context", self.context)

    def tearDown(self):
        # The only recursively removed path is the newly created, checked temporary fixture root.
        self.repository.relative_to(Path(tempfile.gettempdir()).resolve())
        self.storage.cleanup()

    def write(self, name, data):
        path = self.repository / "translations/source" / (name + ".json")
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(json.dumps(data, ensure_ascii=False, indent=2), encoding="utf-8")

    def test_unchanged_semantics_have_no_pending_reviews(self):
        self.assertEqual(review.compare(self.repository, self.state)["affectedLocales"], {})

    def test_one_source_change_invalidates_only_that_key_in_each_locale(self):
        self.source["strings"]["example"] = "Send read receipt to {name}"
        self.write("en", self.source)
        result = review.compare(self.repository, self.state)
        self.assertEqual(result["reviewRequiredEntryCount"], 2)
        for locale in result["affectedLocales"].values():
            self.assertEqual(locale["reviewRequiredKeys"], ["example"])

    def test_context_change_invalidates_the_affected_key(self):
        self.context["entries"]["example"]["meaning"] = "remote receipt"
        self.write("context", self.context)
        result = review.compare(self.repository, self.state)
        self.assertEqual(result["sourceOrContextChangedKeys"], ["example"])
        self.assertEqual(result["reviewRequiredEntryCount"], 2)

    def test_target_change_does_not_invalidate_other_locales(self):
        self.source["strings"]["example"] = "A different translation {name}"
        self.write("example-locale", self.source)
        result = review.compare(self.repository, self.state)
        self.assertEqual(list(result["affectedLocales"]), ["example-locale"])
        self.assertEqual(result["sourceOrContextChangedKeys"], [])
        self.assertEqual(result["reviewRequiredEntryCount"], 1)

    def test_added_source_key_is_pending_for_every_locale(self):
        self.source["strings"]["new"] = "New action"
        self.write("en", self.source)
        result = review.compare(self.repository, self.state)
        self.assertEqual(result["sourceOrContextChangedKeys"], ["new"])
        self.assertEqual(result["reviewRequiredEntryCount"], 2)

    def test_deleted_source_key_is_reported_without_discarding_other_reviews(self):
        del self.source["strings"]["example"]
        self.write("en", self.source)
        result = review.compare(self.repository, self.state)
        self.assertEqual(result["sourceOrContextChangedKeys"], ["example"])
        self.assertEqual(result["reviewRequiredEntryCount"], 2)


if __name__ == "__main__":
    unittest.main()
