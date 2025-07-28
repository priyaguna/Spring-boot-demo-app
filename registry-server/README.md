
# Enabling eureka server
Add EnableEurekaServer annotation in main class 
# application.properties
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false


# To run the server 

Get http://localhost:8761/

# Account App integration in eureka server
1. Add spring-cloud-starter-netflix-eureka-client dependency with dependency management

# application.properties in account app
eureka.client.service-url.defaultZone= http://localhost:8761/eureka/
eureka.client.register-with-eureka= true
eureka.client.fetch-registry= true





