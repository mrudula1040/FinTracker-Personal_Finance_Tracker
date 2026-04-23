# 💰 FinTracker – Personal Finance Tracker (REST API)
FinTracker is a backend REST API application built using Spring Boot that helps users manage their personal finances by tracking income and expense transactions.
The system allows users to register, log in, manage financial transactions, and view a dashboard summary of their financial activity

----

## 🚀 Features

- User Registration
- User Login
- Add Income & Expense Transactions
- View All Transactions for a User
- Filter Transactions by Type
- Update Transaction
- Delete Transaction
- Dashboard Summary (Total Income, Total Expense, Balance)

---- 

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- MapStruct
- Maven

----

## 🏗 Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database

This ensures clean structure and separation of concerns.The project follows a layered architecture:

Controller → Service → Repository → Database
This architecture helps maintain clean code, separation of concerns, and easier maintenance.

----

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

----
## 📁 Project Structure

controller
service
repository
entity
dto
mapper
exception


----

## 🗃 Database Entities
`User


id
name
email
password

`Transaction

id
amount
type (INCOME / EXPENSE)
description
date
userId

----

## 🧪 API Testing

- Tested all REST APIs using Postman
- Verified HTTP status codes (200, 400, 401, 404)
- Validated request and response data
- Tested user authentication (login & registration)
- Checked edge cases like:
  - Invalid login credentials
  - Duplicate email registration
  - Invalid transaction inputs
- Verified business logic (income, expense, balance calculation)

----

## 📚 What I Learned

Through this project, I gained hands-on experience in:

- Designing and developing RESTful APIs using Spring Boot
- Implementing layered architecture (Controller, Service, Repository)
- Handling data transfer using DTO and MapStruct
- Managing relational databases with Spring Data JPA
- Writing business logic for financial calculations (income, expense, balance)
- Performing API testing using Postman
- Validating API responses, status codes, and edge cases
- Understanding how backend development and testing work together to ensure application quality

----
## ⚙️ How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application
4. Test APIs using Postman

----

## 🗄 Database Configuration Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fintracker
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
