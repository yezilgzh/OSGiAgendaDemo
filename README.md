OSGiAgendaDemo
==============

This a is a little project for getting into OSGi, Bndtools and Remote Services.

It consists of:

agenda.api
  - provides the interface (maintaining conferences) used in this project
  
agenda.service.simple
  - provides the implementation of the api and a gogo command
  - service can be published with Remote Service Admin
  
agenda.client.console
  - a client which just prints existing conferences to sysout on start
  - contains a run configuration, which publishs the simple implementation as remote service

agenda.client.rest
  - a client of the agenda service which offers a REST service
  - conatins a run configuration, which consumes the agenda service via Remote Service Admin

agenda.itest.simple
  - a very simple integration test

agenda.itest
  - a not so simple integration test ;)
  

  
