call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runapp
echo.
echo cannot execute runcrud.bat – breaking work
goto fail

:runapp
set url="http://localhost:8080/crud/v1/tasks"
start "" %url%
if "%ERRORLEVEL%" == "0" goto end
echo.
echo problems with localhost or web browser - breaking work

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.