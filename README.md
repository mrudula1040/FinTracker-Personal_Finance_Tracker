# 💰 FinTracker - Personal Finance Tracker (REST API)

FinTracker is a Spring Boot based REST API that allows users to manage their personal income and expense transactions.

The application supports user registration, login, transaction management, and dashboard summary calculation.

---

## 🚀 Features

- User Registration
- User Login
- Add Income & Expense Transactions
- View All Transactions for a User
- Filter Transactions by Type
- Update Transaction
- Delete Transaction
- Dashboard Summary (Total Income, Total Expense, Balance)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- MapStruct
- Maven

---

## 🏗 Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

This ensures clean structure and separation of concerns.

---

## 📌 API Endpoints

### User APIs
- `POST /api/users/register`
- `POST /api/users/login`

### Transaction APIs
- `POST /transactions/user/{userId}`
- `GET /transactions/user/{userId}`
- `GET /transactions/user/{userId}/dashboard`
- `GET /transactions/user/{userId}/type/{type}`
- `PUT /transactions/{id}`
- `DELETE /transactions/{id}`

---

## ⚙️ How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application
4. Test APIs using Postman

---

## 🗄 Database Configuration Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fintracker
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
