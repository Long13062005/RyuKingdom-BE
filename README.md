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

### API Endpoints
    The backend exposes RESTful API endpoints for interacting with the system.

    # Authentication
        POST /api/auth/register - Register a new user
        POST /api/auth/login - Login to receive a JWT token
    # Room Management
        GET /api/rooms - List all rooms
        POST /api/rooms - Create a new room
        PUT /api/rooms/{id} - Update room information
        DELETE /api/rooms/{id} - Delete a room
    # Reservation Management
        POST /api/reservations - Make a new reservation
        GET /api/reservations - View all reservations
        DELETE /api/reservations/{id} - Cancel a reservation 
    # Payment
        POST /api/payments - Process a payment
        GET /api/payments/{id} - View payment details
