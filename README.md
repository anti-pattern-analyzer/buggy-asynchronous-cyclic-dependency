# buggy-asynchronous-cyclic-dependency

This repository contains buggy microservices code with cyclic dependencies that are using asynchronous calls.

Consider three microservices: Service A, Service B, and Service C.
- Service A depends on Service B.
- Service B depends on Service C.
- Service C depends on Service A.

Technologies
- Java
- RabbitMQ
