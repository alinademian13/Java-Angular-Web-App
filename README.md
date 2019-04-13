# Students Catalogue 
  – is a Web application written in Java using Spring Boot and Angular 7. It allows managing students’ marks obtained at different         disciplines. The connection to the database and the tables were created using Spring Data JPA (Hibernate). The front end was built       with Angular 7 using TypeScript.

## Getting Started
To get started, clone the project to your local directory:
```sh
$ git clone https://github.com/alinademian13/Java-Angular-Web-App.git
```

### Prerequisites
What you will need:
-	Java and Java SDK
-	NodeJS and NPM
-	Angular CLI
-	PostgreSQL Database

### Installing
First, build the project using Gradle. Next, install all of the Angular dependencies:
```sh
$ cd catalog-web\src\main\webapp\
$ npm install
```

## App Configuration
The following configuration is required:
-	Create a database named 'project'
-	Database Configuration (file: db.properties)
-	catalog-web\src\main\resources\local\db.properties

```
db.jdbcUrl = jdbc:postgresql://localhost:5432/project
db.username = postgres
db.password = alinad
db.generateDDL = true
```

## Angular Development Server
From inside of the webapp\ folder:
```sh
$ cd catalog-web\src\main\webapp\
$ npm start
```
This will start an instance of the development server at: http://localhost:4200

## Spring Server
Before making any requests to your API, make sure to start the backend server (use Tomcat) and that PostgreSQL is running.

## Built With
-	Angular 7 - Frontend framework
-	Gradle - Dependency Management
-	Spring Boot - Backend Framework
