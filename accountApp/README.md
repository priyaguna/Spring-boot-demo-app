
# To switch default env to dev

1. Select Run configuration
2. Click on Add VM Option
3. Enter "-Dspring.profiles.active=dev" in VM Option
4. Click Apply and OK


# yml configuration to connect to config server
spring:
  application:
    name: accounts
config:
  import: optional:configserver:http://localhost:8089/

# Run the app
1. Start both config Server and Account app
2. Get http://localhost:8087/accounts-app/config-property