## Shift service

Shift service is a multi-module project with several Spring Boot executables which aims to: 
- generate shift data over a REST endpoint
- periodically consume this endpoint with an ETL job and store it in the database

### Modules 

- **rest-provider-api** contains the specification of REST API
- **rest-provider-service** implements the API contract and generates random shift data with every call
- **shift-consumer** ETL which periodically consumes the shift's REST endpoint and stores the result in the database

### Prerequisites 

Shift service requires Java 15. 

### TODO list

- Add javadoc - it is a fairly simple application, but it is embarrassing not to have it
- Add automatic tests - check the state of db to verify the ETL processed the data properly
- Add unit tests
- Improve entity model to reduce the number of executed statements
- Add healthcheck

### Build and run the application 
The application can be built by executing the following command in the parent directory

`./mvnw clean package`

The process builds the applications and runs the unit tests.

To run the applications on the local machine, use the following commands

`./mvnw spring-boot:run -pl rest-provider-service`

`./mvnw spring-boot:run -pl shift-consumer`

This will start the rest-provider-service at http://localhost:8080 and shift-consumer at http://localhost:8081

The rest-provider-service has a GET endpoint which can be accessed at http://localhost:8080/api/shifts?numberOfShifts=X 
where _numberOfShifts_ is a required parameter representing the number of generated shifts. Value "X" must be 1 or higher.

The **shift_consumer** maintains an in-memory H2 database which can be accessed at http://localhost:8081/h2-console
