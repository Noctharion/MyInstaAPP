[CmdletBinding()]
param(
    [Parameter(Mandatory=$true)][ValidateSet('validate','export','prepare')][string]$Command,
    [string]$File,
    [string]$Output,
    [string]$Locale='pt-PT',
    [string]$Repository,
    [switch]$Default
)
$ErrorActionPreference='Stop'
$project=Split-Path -Parent (Split-Path -Parent $PSScriptRoot)
if(!$Repository){$Repository=$project}
$catalog=Join-Path $project 'translations/source/en.json'
$classes=Join-Path $PSScriptRoot 'build/classes'
New-Item -ItemType Directory -Path $classes -Force | Out-Null
$sources=@(Get-ChildItem -LiteralPath (Join-Path $PSScriptRoot 'src') -Recurse -File -Filter '*.java' | ForEach-Object {$_.FullName})
& javac -encoding UTF-8 --release 11 -d $classes @sources
if($LASTEXITCODE -ne 0){throw 'Translation tool compilation failed. Install a JDK 11 or newer.'}
$arguments=@($Command,$catalog)
switch($Command){
    'export' {
        if(!$Output){$Output=Join-Path $PSScriptRoot "build/translators/$Locale"}
        $arguments+=@($Output,'-',$Locale)
    }
    'validate' {
        if(!$File){throw 'Supply -File for validation.'}
        $arguments+=(Resolve-Path -LiteralPath $File).Path
    }
    'prepare' {
        if(!$File){throw 'Supply -File for publication preparation.'}
        $arguments+=@((Resolve-Path -LiteralPath $File).Path,(Resolve-Path -LiteralPath $Repository).Path)
        if($Default){$arguments+='default'}
    }
}
& java '-Dfile.encoding=UTF-8' -cp $classes app.myinsta.tools.TranslationCatalogTool @arguments
if($LASTEXITCODE -ne 0){throw 'Translation validation/preparation failed. No publication was performed.'}
