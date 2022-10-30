# Microservices Real-states

## 1. What is an API gateway?
  An API gateway is a server that acts as an intermediary between a client and an application. It is a web application that handles all the incoming requests and routes them to the appropriate backend service. It also provides a way to monitor and manage the backend services.

## 2. Why use an API gateway in a microservice's architecture?
API Gateway is a microservices pattern and an architectural style for designing scalable and maintainable software. When building a microservice's architecture, it is important to consider how the different services will communicate with each other. One option is to use an API gateway.

An API gateway is a microservice that acts as an entry point for other microservices. It is responsible for request routing, API composition, and load balancing. It can also provide additional features such as authentication, rate limiting, and monitoring.

There are several benefits to using an API gateway in a microservice's architecture. First, it can help to reduce the complexity of the overall system by hiding the details of the individual microservices from the clients. Second, it can improve performance by caching common requests and load balancing requests across multiple microservices. Third, it can provide a single point of authentication and authorization for all microservices.
Fourth, it can help to improve the stability of the overall system by providing a fallback mechanism for failed requests. Fifth, it can provide a central place for monitoring and logging. Sixth, it can make it easier to roll out and roll back changes to the microservices.

In summary, an API gateway can help to reduce the complexity of a microservices' architecture, improve performance, provide a single point of authentication and authorization, improve stability, and provide a central place for monitoring and logging.

## 3. How does an API gateway work?
An API gateway is a type of proxy server that sits between a client and a backend server. It is used to route requests from clients to backend servers. It can also be used to perform other tasks such as authentication, rate limiting, and caching.

## 4. What are the benefits of using an API gateway?
An API gateway is a server that acts as a single point of entry for a set of microservices. An API gateway is a layer 7 load balancer that routes HTTP requests to the appropriate microservice.

API gateways are used to provide a single, unified API interface for a microservice architecture. They can be used to hide the complexity of the underlying microservices, provide a single point of entry for external consumers, and provide a set of features such as authentication, rate limiting, and caching.

API gateways can improve the performance of a microservice architecture by providing features such as caching and request batching. They can also provide a higher level of security by providing features such as authentication and rate limiting.

## Architecture Project
![Real-state's project architecture](/spring-boot-microservice-3-api-gateway/architecture-microservices-apigateway.PNG)
