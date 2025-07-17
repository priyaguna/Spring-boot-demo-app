# Spring-boot-demo-app
Spring boot application connected to h2 database

# Spring Boot REST API Handbook: Bank Account Management
This guide walks through the development of a Spring Boot application to manage bank account holder details. 
Entity: User
•	Fields: id, username, firstName, lastName, mobileNumber, email
Entity: Account
•	Fields: accountId, branch, accountType, user (foreign key)
Functionalities
•	Add new account
•	Update full account details
•	Patch email or firstName only
•	Delete account
•	Get account by ID
•	Get all accounts
•	Search account by mobile number
Extras
•	Validation annotations
•	Global exception handling
•	Custom HTTP Header: userInfo
•	Spring Data JPA
•	H2 database

 # Maven Dependencies
Make sure your pom.xml includes:

1. spring-boot-starter-web
2. spring-boot-starter-data-jpa
3. h2 database
4. hibernate-validator
5. jakarta.validation-api
6. lombok


# Global Exception Handling Using ControllerAdvice is handled in this project


# application.properties
spring.datasource.url=jdbc:h2:mem:bankdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
Open H2 Console at:
http://localhost:8080/h2-console
Use JDBC URL: jdbc:h2:mem:bankdb

# Testing the APIs
Use IntelliJ HTTP Client or Postman to test:
### Create Account
POST http://localhost:8080/accounts
Content-Type: application/json
userInfo: trainee01

{
  "branch": "Mumbai",
  "accountType": "Savings",
  "user": {
    "username": "john_doe",
    "firstName": "John",
    "lastName": "Doe",
    "mobileNumber": "9876543210",
    "email": "john@example.com"
  }
}

# yml file properties
 
spring:
  datasource:
    url: jdbc:h2:mem:bankdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
  h2:
    console:
      enabled: true
branch:
  branches:
    1: "BLR"
    2: "MUM"



# Summary
Feature	Description
@Entity, @Repository	ORM mapping using Spring Data JPA
@RestController	API definition layer
@Valid, @NotBlank, @Email	Field-level validation
@ControllerAdvice	Centralized exception handler
H2	In-memory database with web console
Custom Header	userInfo accepted on each API call


 # Integration Test with H2 and MockMvc (No Repository Mocking)
✔️ What this test will do:
Create an account
Fetch and verify the account
Update (patch) the email and first name
Fetch again and verify the updates
🧪 Required Dependencies (already included in your pom.xml):
Ensure these are present:
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
🧪 Test Class
Create the file:

src/test/java/com/bank/bank_accounts/BankAccountIntegrationTest.java
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class BankAccountIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateFetchUpdateAccount() throws Exception {
        // Step 1: Create Account
        String createJson = """
        {
          "branch": "Bangalore",
          "accountType": "Savings",
          "user": {
            "username": "jane_doe",
            "firstName": "Jane",
            "lastName": "Doe",
            "mobileNumber": "9876543211",
            "email": "jane@example.com"
          }
        }
        """;

        MvcResult createResult = mockMvc.perform(post("/accounts")
                .header("userInfo", "integration-test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.branch").value("Bangalore"))
            .andReturn();

        String responseJson = createResult.getResponse().getContentAsString();
        Account createdAccount = objectMapper.readValue(responseJson, Account.class);
        Long accountId = createdAccount.getAccountId();

        // Step 2: Fetch and verify
        mockMvc.perform(get("/accounts/" + accountId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user.username").value("jane_doe"));

        // Step 3: Patch email and first name
        String patchJson = """
        {
          "email": "jane.updated@example.com",
          "firstName": "Janet"
        }
        """;

        mockMvc.perform(patch("/accounts/" + accountId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(patchJson))
            .andExpect(status().isOk());

        // Step 4: Fetch again and verify changes
        mockMvc.perform(get("/accounts/" + accountId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user.email").value("jane.updated@example.com"))
            .andExpect(jsonPath("$.user.firstName").value("Janet"));
    }
}



💡 Notes
@SpringBootTest boots the full application context.
@AutoConfigureMockMvc injects a MockMvc instance to simulate HTTP requests.
@Transactional ensures DB changes are rolled back after each test.





