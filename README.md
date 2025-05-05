# SpringFinder

SpringFinder is a Spring Boot application that exposes a `/user-info` REST endpoint to look up user records by CPF, name, or date of birth from a backed database.

## Code Structure

The project follows the standard Maven layout:
- **`.mvn/`, `mvnw`, `mvnw.cmd`, `pom.xml`**  
  Maven wrapper and build configuration.  
- **`src/main/java/com/pampa/springfinder`**  
  - `SpringfinderApplication.java`: Main application entry point.  
  - `controller/`: REST controllers handling HTTP requests.  
  - `service/`: Business logic services.  
  - `repository/`: Data access layer interfaces.  
  - `model/`: Domain model classes.  
  - `config/`: Configuration classes (e.g., datasource).  
- **`src/main/resources`**  
  - `application.properties`: Server and datasource settings.  
  - `templates/`: Thymeleaf HTML templates.  
## Use Instructions
The usage is very simmple, the user may run the application, setting an SQLite3 database path and a port.
It will be possible to see the requests coming from the HTTPS REST endpoint built onto the service.
Once the requests come from the SpringFinder Client, it will be made a look up in the database and the data will be sent back to the client as a JSON with a list of user objects.

### Prerequisites
- Java 21 or higher  
- Maven 3.6+  
- A running relational database populated with user data containing:
  - cpf (cpf)
  - name (nome)
  - gender (sexo)
  - birth date (nasc)

### Clone and Build
```bash
git clone https://github.com/pampacomputing/springfinder.git
cd springfinder
./mvnw clean package
