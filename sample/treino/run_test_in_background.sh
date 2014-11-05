#!/bin/bash

# Impede que o terminal seja fechado automaticamente (Padrao do SERPRO)
export TMOUT=0

MAVEN_COMMAND=/usr/bin/mvn

# Start Xvfb if not already running
ps axu | grep "Xvfb :4 -screen 0 1024x768x24" | grep -v "grep" > /dev/null
if [ $? != 0 ] # $? return value of last command execution: = 0 if terminate with sucess, != 0 if not sucessfull. In this case, ps axu above 
then
   `which Xvfb` :4 -screen 0 1024x768x24 &
   `which x11vnc` -display :4 &
fi


DISPLAY=:4 time $MAVEN_COMMAND test -Dtest=$1
