#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=base.daemon.motorFluxoAtividade/target/base.daemon.motorFluxoAtividade-1.3.0-SNAPSHOT.jar:base.daemon.motorFluxoAtividade/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eapli.base.daemon.motorFluxoAtividade.MotorFluxoAtividadeDaemon




