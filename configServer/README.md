# Spring-boot-demo-app
Spring boot application config server for microservices

# Dependency 
Spring config server
Spring actuator

# Rest API
Get http://localhost:8089/accounts/dev

# To get properties from account App endpoint which is config for dev

Get http://localhost:8087/accounts-app/config-property

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
  port: 8089




