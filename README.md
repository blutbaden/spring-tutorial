# Getting Started

### Build the native application
The native application can be built as follows:
    
    mvn spring-boot:build-image
    
### Run the native application
To run the application, you can use docker
    
    docker run --rm -p 8080:8080 spring-tutorial:0.0.1-SNAPSHOT

### Testing api
To check if the application is running you can call this api:

    localhost:8080/greeting
