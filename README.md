#  Incident Dashboard

A open board where every person with access to it can see, add, update or delete 
incident. This project is thought to be a module of an incident management application.  
 
A Spring boot microservice using Thymeleaf as template engine and MariaDB.

## Getting Started
### Prerequisites
* Maven
* MariaDB

### Using IDE 

1. Get the source code, v.g. `git clone https://github.com/hugotiburtino/incident-dashboard`.

2. Open its folder as Maven project at your IDE.
3. Change the name and password of the MariaDB user at *src/main/resources/application.properties*. For example:
```
spring.datasource.username=root
spring.datasource.password=changeme
```
4. Run the project as Java Application. Open the browser at localhost:8080


### Using Terminal
1. `git clone https://github.com/hugotiburtino/incident-dashboard`
2. `cd incident-dashboard`
3. `mvn clean`
4. `nano src/main/resources/application.properties` and change the name and
password of the MariaDB user to match the 
4. `mvn compile`
5. `mvn package`
6. `java -jar target/incidentdashboard-1.0.0-SNAPSHOT.jar`


## Built with
* Spring Boot
* Tomcat
* Thymeleaf
* Hibernate
* MariaDB
* Maven
* Bootstrap 4

## Acknowledgments
This project used as starter code the project DIKUKA that **Georg Kromer**, **Gergely Szalay** 
and Hugo Tiburtino programmed in a Java bootcamp at AW Academy. 
Special thanks to the teacher Oliver Hock.
