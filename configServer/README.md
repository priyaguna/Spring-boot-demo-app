# Spring-boot-demo-app
Spring boot application config server for microservices

# Dependency 
Spring config server
Spring actuator

# Rest API
Get http://localhost:8085/accounts/dev

# yml file properties
 
spring:
  application:
    name: configServer
  profiles:
    active: native
  cloud:
    config:
      server:
        native:
          search-locations: "classpath:/configPath"
server:
  port: 8088




