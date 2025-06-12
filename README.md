# 🩺 Hospital Management System – Backend API

A backend REST API built with **Java**, **Spring Boot**, and **MySQL** to manage hospital operations such as patients, doctors, and billing records. Designed for modularity and ease of integration with any frontend. All endpoints are tested using **Postman**.

---

## ⚙️ Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **Database:** MySQL  
- **Build Tool:** Gradle  
- **Testing:** Postman

---

## 📌 Features

- Add, view, update, and delete:
  - Patients
  - Doctors
  - Bills
- CRUD operations for all entities
- Layered architecture: Controller → Service → Repository
- Relational mapping using JPA & Hibernate
- Clean RESTful endpoints with standard HTTP methods

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Pawan-Pandey1/HospitalManagementSystem.git
cd HospitalManagementSystem
```

### 2. Configure Database

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospitaldb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

Make sure to create the `hospitaldb` database in your MySQL server.

---

### 3. Run the Application

Using Gradle Wrapper:

```bash
./gradlew bootRun
```

Or from your IDE (like IntelliJ or Spring Tool Suite), run the `HospitalManagementSystemApplication.java` class.

App runs on:  
**http://localhost:8080**

---

## 📮 Sample REST API Endpoints

| Method | Endpoint               | Description              |
|--------|------------------------|--------------------------|
| GET    | `/patients`            | Get all patients         |
| POST   | `/patients`            | Add a new patient        |
| GET    | `/doctors`             | Get all doctors          |
| POST   | `/doctors`             | Add a new doctor         |
| GET    | `/bills`               | Get all billing records  |
| POST   | `/bills`               | Add a new bill           |
| PUT    | `/patients/{id}`       | Update patient by ID     |
| DELETE | `/doctors/{id}`        | Delete doctor by ID      |

🧪 All endpoints tested via Postman.

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/hospital/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── service/
│   │       └── repository/
│   └── resources/
│       └── application.properties
```

---

## 🙌 Acknowledgements

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [MySQL Docs](https://dev.mysql.com/doc/)
- [Postman](https://www.postman.com/)
