# PAF-GroupBuild 
Restful CRUD API for a E-commerce webapp using Spring Boot, Mysql.
Requirements

    Java - 1.8.x

    Maven - 3.x.x

    Mysql - 5.x.x

Steps to Setup

1. Clone the application

git clonehttps://github.com/Ranushklakmal/PAF-Group.git

2. Create Mysql database

create database 

3. Change mysql username and password as per your installation

    open src/main/resources/application.properties

    change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

you can run the app without packaging it using -

mvn spring-boot:run

The app will start running at http://localhost:8086
Explore Rest APIs

The app defines following CRUD APIs.

GET /api/xxx

POST /api/xxxx

GET /api/xxx/{xxxID}

PUT /api/xxx/{xxxID}

DELETE /api/xxx/{xxxID}

You can test them using postman or any other rest client.
