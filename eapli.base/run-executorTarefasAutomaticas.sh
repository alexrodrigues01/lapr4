#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=base.daemon.executorTarefasAutomaticas/target/base.daemon.executorTarefasAutomaticas-1.3.0-SNAPSHOT.jar:base.daemon.executorTarefasAutomaticas/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eapli.base.daemon.executorTarefasAutomaticas.ExecutorTarefasAutomaticasDaemon