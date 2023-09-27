Get-ChildItem . *.java -recurse |
    Foreach-Object {
        $c = ($_ | Get-Content) 
        $c = $c -replace '<add key="Environment" value="package java.util"/>','<add key="Environment" value="package myJava.util"/>'
        [IO.File]::WriteAllText($_.FullName, ($c -join "`r`n"))
    }