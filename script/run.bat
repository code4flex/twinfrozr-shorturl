@echo off
echo.
echo [info] run status¡£
echo.

cd %~dp0
cd ../shorturl-restful/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% shorturl-restful.jar

cd bin
pause