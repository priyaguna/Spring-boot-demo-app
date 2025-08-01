# Spring-boot-demo-app
Spring boot application config server for microservices

# Dependency 
Spring config server
Spring actuator

# Rest API
Get http://localhost:8089/accounts/dev

# Account Actuator
Get http://localhost:8087/actuator

# To refresh the properties changed in config server without restarting account app we can use actuator endpoint

Actuator provide the endpoint to refresh the properties from config server.

Post http://localhost:8087/actuator/refresh


# To get properties from account App endpoint which is config for dev

Get http://localhost:8087/accounts-app/config-property


