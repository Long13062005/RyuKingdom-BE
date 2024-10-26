# RyuKingdom's Hotel Management System - Backend

This is the backend for the Hotel Management System, designed to handle the core business logic, data management, and API endpoints for managing hotel operations like reservations, check-ins, payments, room and service management.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Installation](#Installation)

---

## Features
- User authentication and role-based access control (customer, receptionist, admin)
- CRUD operations for managing rooms, reservations, customers, and services
- Real-time check-in and check-out handling
- Payment management
- Reporting for admin to track hotel performance and service utilization

## Technologies Used
- **Java** (Spring Boot) - Core backend framework
- **Spring Security** - Authentication and authorization
- **JPA/Hibernate** - ORM for database interaction
- **MySQL** - Relational database
- **Swagger** - API documentation
- **JUnit** - Unit testing framework

## Getting Started

### Prerequisites
- **Java** 11 or above
- **Gradle** build tool
- **MySQL** server

### Installation
DATABASE_URL=jdbc:mysql://localhost:3306/hotel_management
DATABASE_USERNAME=your_username
DATABASE_PASSWORD=your_password
