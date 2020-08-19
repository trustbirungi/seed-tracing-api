**Seed Tracing API**

This is the backend that provides the Rest API for the Bioversity Seed Tracing App.

It's a Spring Boot application written in Java and built with Maven. To run it, the following prerequistes are needed:

 - Java 8+.
 - MySQL 8.

**Installation**

 1. Clone this repo.
 2. cd to the root of the cloned repo.
 3. Navigate to 'src/main/resources/'.
 4. Rename the file 'application.example.yml' to 'application.yml'
 5. Set the URL of the database, and the username and password for the database.
 6. Run the database migrations
 7. From the root directory of the cloned repo, run `mvn clean install`. This will download all the necessary dependencies and build the project.
 8. From the root directory of the cloned repo, run `mvn spring-boot:run` to start the application. The application will be running on port 8080 so ensure that port is available.
 9. Once the application is running, you can access it via the web frontend at seedtracer.cgiar.org or any other Rest client
  such as
  Postman.

**Testing**
To execute the tests, cd to the root directory of the cloned repo and run the following command `mvn test`.
