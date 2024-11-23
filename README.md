# Golf Tournament Management System

---

### Written by: Rodney Stead
### Written on: 2024-11-23

---
## Description
The Golf Tournament Management System is an application designed to streamline the organization and management 
of golf tournaments. It allows users to create and manage tournaments, register members, and track tournament details. 
The system is built using Java, Spring Boot, and Maven.

---

## Project Requirements
    This project was built for use of running the application in a docker container, and useing postman to make requests 
    to the API endpoints, while using MySQL as the Database.
        - Docker Desktop
        - Postman
        - MySQL Workbench

---
## Getting started
### Create the database inside of your MySQL server

        - Database Name: golf_tournament_db

### In your application.properties file, adjust the following

        - spring.datasource.username = root      -> Change root to your MySQL username
        - spring.datasource.password = password  -> Change password to your MySQL password

### Docker Setup

        - Ensure that your docker Desktop application is running
        - docker build -t tournament_api .
            -> if it did not build clean, use the following command: mvn clean package 
            -> run the docker build command again
        - docker compose up
            -> Press V in the terminal to view the docker logs
---
## Setting up the Database with Postman

    All post requests required for setting up the database are located under the src/main/resources/input folder
    Must be done in the following order:
    
        -> MemberAddress -> Member -> Locations -> Tournaments

        MemberAddress -> API Endpoint: http://localhost:8080/member-addresses
        Member -> API Endpoint: http://localhost:8080/members
        Locations -> API Endpoint: http://localhost:8080/tournament-locations
        Tournaments -> API Endpoint: http://localhost:8080/tournaments

---
## API Endpoints

    - Member Address
        -Get all member addresses -> GET: http://localhost:8080/member-addresses

    - Member
        - Get all members -> GET: http://localhost:8080/members
        - Get member by phone number -> GET: http://localhost:8080/members/phone/1234567890
        - Get member by name -> GET: http://localhost:8080/members/name/John Doe
        - Get member by start date of membership -> GET: http://localhost:/members/start-date/2024-06-01
        - Get member by membership type, this has 2 options as I set 6 or 12 months and the endpoints are as follows:
            -> 6 months -> GET: http://localhost:8080/members/membership-type/half-year
            -> 12 months -> GET: http://localhost:8080/members/membership-type/year
    
    - Tournament Location
        - Only has the Post method for intial setup of the database

    - Tournament
        - Get tournaments by start date in format of yyyy-mm-dd -> GET: http://localhost:8080/tournaments/start-date/2024-06-01
        - Get all tournaments -> GET: http://localhost:8080/tournaments
        - Get tournament by location using the city-> GET: http://localhost:8080/tournaments/by-city/Toronto
        - Get all members in a tournament using the tournament id -> GET: http://localhost:8080/tournaments/members/1
        