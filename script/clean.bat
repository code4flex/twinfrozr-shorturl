@echo off
echo.
echo [info] mvn clean¡£
echo.

%~d0
cd %~dp0

cd ..
call mvn clean

pause