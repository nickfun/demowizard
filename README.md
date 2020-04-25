demowizard
==========

A small server to demonstrate using Guardrail with Dropwizard 1.3

How to start the demowizard application
---------------------------------------

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/demowizard-1.0-SNAPSHOT.jar server config.yaml`
1. To check that your application is running enter url `http://localhost:8080`

What technology is this using?
------------------------------

- [Dropwizard](http://www.dropwizard.io) is the HTTP Framework
- [Guardrail](http://www.guardrail.dev) enhances it by generating our backend routes and validating our spec

See [server-spec](./server-spec.yaml) for the list of routes this service allows.
