
# Shelter Management System 🐾

A **backend-only application** designed to manage a shelter for cats and dogs. This project can be used by everyone that wants to create a platfrom to manage Shelters! :)
---

## **Features**
- Manage **users** (adopters) and **animal information**.
- Store and retrieve data efficiently using **PostgreSQL** and **MongoDB**.
- Deploy notifications with **AWS SNS** using **AWS Lambda**.
- Containerized environment using **Docker** for easy deployment.

---

## **Technologies Used**
### **Backend**
- **Java 21**
- **Spring Boot**
    - Spring Boot DevTools
    - Lombok
    - Spring Web
    - Spring Security
    - Spring Data JPA
    - Spring Data MongoDB
    - Validation

### **Databases**
- **PostgreSQL** (SQL database)
    - Username: `postgres`
    - Password: `test1234`
- **MongoDB** (NoSQL database)
    - No authentication required (configured via Compass URL).

### **Cloud**
- **Docker**
- Feel free to add Kubernetes for container orchestration!
- **AWS**
    - Lambda
    - SNS
    - (It's going to implement S3 and ElastiCache soon 👀)

---

## **Prerequisites**
Ensure you have the following installed:
- Java 21
- Docker
- PostgreSQL
- MongoDB
- AWS Dependency :) -> get an account too!!
---

## **Setup and Installation**
1. **Clone the repository:**
   ```bash  
   git clone https://github.com/repo/shelter-management-system.git  
   cd shelter-management-system  
   ```  

2. **Run PostgreSQL:**
   ```bash  
   docker run --name postgres-container -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=test1234 -p 5432:5432 -d postgres  
   ```  

3. **Run MongoDB:**
   ```bash  
   docker run --name mongo-container -p 27017:27017 -d mongo  
   ```  

4. **Build and run the application:**
   ```bash  
   ./mvnw clean install  
   ./mvnw spring-boot:run  
   ```  

5. **Configure AWS Lambda and SNS:**
    - Set up an **AWS Lambda** function with appropriate triggers.
    - Link it to an **SNS topic** for sending notifications.

---

## **Docker Compose (Optional)**
For running PostgreSQL and MongoDB together:
You can find the complete Docker Compose file inside the root!!
1. Create a `docker-compose.yml` file:
   ```yaml  
   version: '3.8'
   services:
     postgres:
       image: postgres
       container_name: postgres-container
       environment:
         POSTGRES_USER: postgres
         POSTGRES_PASSWORD: test1234
       ports:
         - "5432:5432"

     mongo:
       image: mongo
       container_name: mongo-container
       ports:
         - "27017:27017"
   ```  

2. Start the services:
   ```bash  
   docker-compose up -d  
   ```  

---

## **Project Structure**
- `src/main/java`
    - Core Java and Spring Boot codebase.
- `src/main/resources`
    - Configuration files (e.g., `application.properties`).
- `Dockerfile`
    - For containerizing the application.
- `README.md`
    - Documentation (this file).

---

## **Contributing**
Contributions are welcome! Feel free to fork the repository and submit pull requests.

---

## **License**
This project is open-source and available for everyone :).

---  
