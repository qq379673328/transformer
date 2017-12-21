@echo off

: basedata
set ip=localhost
set user=root
set password=root
set databaseName=transformer

set mysqlBinPath=E:\applications\mysql5.5\mysql-5.5.50-winx64\mysql-5.5.50-winx64\bin\
set mysqlBackupPath=d:\transformer\db_bak
set /a backupDays=7

set logs=%mysqlBackupPath%\logs.txt
set day=%date:~8,2%
set month=%date:~5,2%
set /a year=%date:~0,4%

if not exist %mysqlBackupPath% md %mysqlBackupPath%
echo %year%-%month%-%day% >> %logs%

set backupingFilePath=%mysqlBackupPath%\%databaseName%_%year%-%month%-%day%.sql
cd /d %mysqlBinPath%

echo backupdata >> %logs%
set errorlevel=0
mysqldump -h%ip% -u%user% -p%password% --default-character-set=utf8 --opt --extended-insert=false --triggers -R --hex-blob -x %databaseName%>%backupingFilePath%
set /a myerrorlevel=%errorlevel%
if %myerrorlevel% leq 0 (
if exist %backupingFilePath% (
echo backupcomplete mysqlBackup_%year%-%month%-%day%.sql >> %logs%
) else (
echo backupfaile
echo backupfaile >> %logs%
pause
exit
)
) else (
echo backupfail
echo backupfail >> %logs%
if exist %backupingFilePath% (
del %backupingFilePath%
)
pause
exit
)
rem delete backupDays's backup


set /a day=1%day%-100-backupDays
rem 
if %day% lss 1 (
set /a daysTemp=day
call :daysOfLastMonth
) else set /a daysTemp=0
set /a day+=daysTemp
rem 
if day lss 10 (set day=0%day%)
set /a month=%month%
if %month% lss 10 (set month=0%month%)

set deleteBackupFilePath=%databaseName%%year%%month%%day%.sql
echo mysqlBackup_%year%-%month%-%day%.sql >> %logs%
if exist %mysqlBackupPath%\%deleteBackupFilePath% (
del %mysqlBackupPath%\%deleteBackupFilePath%
 
echo delcomplete >> %logs%
) else (

echo the document isn't exist >> %logs%
)
echo -----------------------------------------------------end >> %logs%


:daysOfLastMonth
set /a month=%month%-1
set /a mod1=%year%%%4
set /a mod2=%year%%%100

if %month% lss 1 (
set month=12
set year=%year%-1
set day=31
) else (
if %month% == 2 (
set day=28
if %mod1% == 0 (
set day=29
if mod2 == 0 (
set day=28
)
)
) else (
for %%a in (1 3 5 7 8 10 12) do (
if %month% == %%a (
set day=31
goto :eof
)
)
set day=30
)
)
goto :eof 
