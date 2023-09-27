$configFiles = Get-ChildItem . *.java -rec
foreach ($file in $configFiles)
{
    (Get-Content $file.PSPath) |
    Foreach-Object { $_ -replace "package java.util;", "package myJava.util;" } |
    Set-Content $file.PSPath
}