# Dev Environment
1. Framework : Spring Boot 2.X
2. Database : H2
3. Persistence : Hibernate, JPA
4. Language : Java 1.8
5. Dependency : Maven
6. Etc : Lombok, json-simple

# How to access H2 Console
1. Run application.
2. Open browser.
3. Go to http://localhost:8080/h2-console
4. Rewrite JDBC Url as "jdbc:h2:mem:testdb"
5. Connect.

# URL of swagger
1. http://localhost:8080/swagger-ui.html

# Features
1. Provide hero list.
2. Provide hero information.
3. Provide hero's abilities.
4. Provide ability information.

# Pre requirement to run
1. Java 1.8+
2. Maven 3.6+

# How to run application
1. Run script "mvn spring-boot:run"