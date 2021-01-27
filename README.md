## Product Microservice 

An Example project to demonstrate:
* How to create a Spring Boot JPA Api Rest
* Hot to run Spring Boot in Docker and publish to Docker Hub
* Hot to deploy the Spring Boot application to AWS with CloudFormation

## Pre-requisites

* JDK 11+
* Docker

## Building

### Testing

`./gradlew test`

### Building (no tests)

`./gradlew assemble`

### Building (with tests)

`./gradlew build`

### Running in Docker

`./gradlew assemble docker dockerRun`

### Stopping Docker container

`./gradlew dockerStop`

### Deploying to AWS

`./gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=<your-subnet-id> -Pregion=<your-region>`

### Deleting AWS deployment

`./gradlew awsCfnDeleteStack awsCfnWaitStackComplete`

## Using API

* get all products - GET [/products](http://localhost:8080/api/products) to get a list of all the products
* get a specific product - GET [/products/${id}](http://localhost:8080/api/products/1) to get a specific product
* create product - POST JSON to [/products](http://localhost:8080/api/products) to create a new product
 