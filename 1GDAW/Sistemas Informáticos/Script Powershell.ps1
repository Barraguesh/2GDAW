#Script Powershell SI
Write-Host Script Powershell sistemas

New-Item -Path C:\Scripts\dir1 -ItemType directory
New-Item -Path C:\Scripts\dir1\dir2 -ItemType directory
New-Item -Path C:\Scripts\dir4 -ItemType directory
New-Item -Path C:\Scripts\fichero1.txt -ItemType file
New-Item -Path C:\Scripts\dir1\fichero3.txt -ItemType file
New-Item -Path C:\Scripts\dir1\dir2\fichero4.txt -ItemType file
Get-ChildItem -Path C:\Scripts
