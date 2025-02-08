# 🌍 VoyageEase - Travel Booking System

VoyageEase is a full-stack travel booking system built with **Spring Boot** and **Angular**. It enables users to purchase vacation packages with excursions and manages orders efficiently with a MySQL database.

## 🚀 Tech Stack

### **Frontend**
- **Framework:** Angular 16+
- **Languages:** TypeScript, HTML, CSS
- **State Management:** Services & RxJS
- **HTTP Client:** Angular HttpClient

### **Backend**
- **Framework:** Spring Boot 3+
- **Languages:** Java 17
- **ORM:** Hibernate with Spring Data JPA
- **Validation:** Hibernate Validator (Jakarta Validation API)
- **Logging:** SLF4J with Logback

### **Database**
- **SQL Database:** MySQL
- **Database Management:** MySQL Workbench
- **Schema Design:** Entity Relationships (One-to-Many, Many-to-One)
- **Persistence:** Spring Data JPA

### **DevOps & Tools**
- **Build Tool:** Maven
- **Dependency Management:** Spring Boot Starter Dependencies
- **Version Control:** Git, GitHub
- **IDE:** IntelliJ IDEA, VS Code (for frontend)
- **API Testing:** Postman

## 📂 Project Structure

VoyageEase/
│── Backend/
│   ├── src/main/java/com/example/d288_backend
│   │   ├── controllers/        # REST API Controllers
│   │   ├── services/           # Service Layer
│   │   ├── repositories/       # Data Access Layer (JPA)
│   │   ├── entities/           # JPA Entities
│   │   ├── BootStrapData.java  # Sample Data Seeding
│   ├── pom.xml                 # Maven Configuration
│── Frontend/
│   ├── src/app/
│   │   ├── components/         # Angular Components
│   │   ├── services/           # Angular Services (API calls)
│   │   ├── models/             # TypeScript Interfaces & DTOs
│   ├── package.json            # Frontend Dependencies
│── README.md                   # Project Documentation
│── .gitignore                   # Git Ignore Configuration


## 💡 Features
- **User Registration & Orders**: Customers can book vacations with excursions.
- **Dynamic Data Handling**: Uses RESTful APIs to fetch and update data.
- **Validation & Error Handling**: Backend validation with Hibernate Validator.
- **Order Management**: Generates unique tracking numbers for each order.
- **Frontend Integration**: Angular frontend consumes the Spring Boot API.
