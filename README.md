# SmartTasker-Task-Management-System
A Spring Boot-based task management system with user authentication, task assignment, email notification, and role-based access. Built using Java, Spring Boot, Hibernate, and MySQL.


# SmartTasker - Task Management System 📝

A full-stack Java Spring Boot-based application to manage user-created tasks with due dates, statuses, and real-time updates.

## 🔧 Tech Stack
- **Backend:** Java, Spring Boot, Hibernate (JPA)
- **Database:** MySQL
- **Email Service:** Spring Mail
- **Tools:** Maven, Lombok

## 📦 Features
- User Registration & Login (with Email Verification)
- Create, Update, Delete Tasks
- Assign tasks to specific users
- Auto-generated timestamps for task creation & due dates
- Role-based User Management
- Exception Handling with custom exceptions
- Response wrapping using generic `ResponseStructure<T>`
- Email notification on login

## 📂 Project Structure
- `dto` - Data Transfer Objects for Users and Tasks
- `repository` - JPA Repositories
- `dao` - Data Access Objects
- `service` - Business Logic Layer
- `util` - Utility classes (Email + Response wrapper)
- `exception` - Custom exception handling
- `SmartTaskerApplication.java` - Spring Boot Main Class

## 📬 Email Integration
Uses `JavaMailSender` to send confirmation emails on login via `EmailUtil`.

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/SmartTasker-Task-Management-System.git
