@echo off
title Register Game Server
color 17
java -Djava.util.logging.config.file=console.cfg -cp ./../libs/* org.l2s.tools.gsregistering.BaseGameServerRegister -c
pause