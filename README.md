Library Management System
Overview
The Library Management System is a web application built with Java Spring Boot and PostgreSQL. It enables users to manage books, authors, and borrowing records with proper authentication and authorization. The system provides role-based access, allowing administrators to manage the library's content while regular users can view and borrow books.

Features
1. Entities & Relationships
Book:
Fields: title, ISBN, publicationDate, status (Available, Borrowed)
Relationship: Many-to-One with Author
Author:
Fields: name, bio
Relationship: One-to-Many with Book
User:
Fields: username, password, role (Admin, User)
Relationship: One-to-Many with BorrowingRecord
BorrowingRecord:
Fields: user, book, borrowDate, returnDate
Relationship: Many-to-One with User and Book
2. CRUD Operations
Admin:
Can create, update, delete, and view books and authors.
User:
Can view books and borrow available ones.
3. JWT Authentication
Implemented JWT-based authentication to secure the API.
Only authenticated users can perform actions on the system.
4. Role-Based Access Control
Admin:
Manage the library (add/edit/delete books and authors).
Regular User:
View books and manage their borrowing records.
5. Validation & Exception Handling
Implemented proper validation on all API endpoints.
Handled exceptions gracefully with appropriate HTTP status codes and messages.
6. Pagination & Sorting
Implemented pagination and sorting on book listing endpoints for efficient data handling.
7. Search Functionality
Users can search for books by title, author, or ISBN.
8. Borrowing Flow
Users can borrow available books, and the system updates the book’s status.
Users can return borrowed books, updating the status and borrowing record accordingly.
Implemented constraints to ensure a user cannot borrow more than a certain number of books at once.
Technologies Used
Backend: Java Spring Boot, Spring Security, JWT for authentication
Database: PostgreSQL
ORM: JPA/Hibernate
Build Tool: Maven
Testing: JUnit, Mockito


It is quite possible that some of the functionalitites may seem undone, you can, however, work on them to complete them.
