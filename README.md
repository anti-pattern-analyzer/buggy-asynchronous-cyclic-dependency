# buggy-asynchronous-cyclic-dependency

This repository contains buggy microservices code with cyclic dependencies that are using asynchronous calls.

## Consider three microservices: Service A, Service B, and Service C.
- Service A depends on Service B.
- Service B depends on Service C.
- Service C depends on Service A.

## Technologies
- Java
- RabbitMQ

## Run RabbitMQ using Docker
```
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.12-management
```

## Test
- Service A depends on Service B- `curl -X POST http://localhost:8080/api/v1/send`
- Service B depends on Service C- `curl -X POST http://localhost:8081/api/v1/send`
- Service C depends on Service A- `curl -X POST http://localhost:8082/api/v1/send`
