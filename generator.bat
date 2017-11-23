@echo off
echo ****************generator mybatis objects*********************

%~d0
cd %~dp0
echo -----------------------generator objects start-------------------------
call mvn mybatis-generator:generate
echo -----------------------all objects generator complete----------------------
echo ****************generator complete*********************
pause