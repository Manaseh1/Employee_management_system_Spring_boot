# Employee Management System

## Overview

This is a demo Spring Boot application that provides a RESTful API for managing employee records. It implements full CRUD (Create, Read, Update, Delete) operations along with advanced querying capabilities. The application uses an H2 in-memory database and includes a simple web interface for basic interactions.

## Technologies Used

- **Java 17**
- **Spring Boot 3.x** (Web, Data JPA, Validation)
- **H2 Database** (In-memory database)
- **Gradle** (Build tool)
- **HTML/CSS/JavaScript** (Simple frontend)

## Architecture

The application follows the Model-View-Controller (MVC) pattern:

### Model
- **Employee Entity** (`Employee.java`): Represents the employee data model with fields like id, firstName, lastName, email, department, and salary. Uses JPA annotations for database mapping and validation constraints.

### View
- **Static HTML Page** (`index.html`): A simple web interface that allows users to interact with the employee data through a browser. It provides forms for creating and updating employees, and displays employee information.

### Controller
- **EmployeeController** (`EmployeeController.java`): REST controller that handles HTTP requests and responses. It exposes endpoints for CRUD operations and various query functionalities.

## CRUD Functionalities

The application implements the following CRUD operations:

### Create
- **Endpoint**: `POST /api/employees`
- **Description**: Creates a new employee record
- **Request Body**: JSON with employee details (firstName, lastName, email, department, salary)
- **Validation**: Ensures required fields are present and email format is valid

### Read
- **Endpoint**: `GET /api/employees`
- **Description**: Retrieves all employees
- **Endpoint**: `GET /api/employees/{id}`
- **Description**: Retrieves a specific employee by ID

### Update
- **Endpoint**: `PUT /api/employees/{id}`
- **Description**: Updates an existing employee record
- **Request Body**: JSON with updated employee details

### Delete
- **Endpoint**: `DELETE /api/employees/{id}`
- **Description**: Deletes an employee record by ID

## Additional Query Functionalities

The application also provides various query endpoints for filtering and searching employees:

- Get employees by department: `GET /api/employees/department/{department}`
- Get employees by salary greater than: `GET /api/employees/salary/greater/{salary}`
- Search by name: `GET /api/employees/search/name/{name}`
- Get employees by salary range: `GET /api/employees/salary-range?min={min}&max={max}`
- And many more advanced queries...

## Database Configuration

The application uses H2 in-memory database with the following configuration:
- Database URL: `jdbc:h2:file:./employeedb`
- H2 Console: Enabled at `http://localhost:8080/h2-console`
- JPA DDL Auto: `update` (automatically creates/updates tables)

## How to Run

1. **Prerequisites**: Java 17 and Gradle installed

2. **Clone/Build**: The project uses Gradle wrapper, so no additional setup needed

3. **Run the Application**:
   ```bash
   ./gradlew bootRun
   ```
   Or on Windows:
   ```cmd
   gradlew.bat bootRun
   ```

4. **Access the Application**:
   - API Endpoints: `http://localhost:8080/api/employees`
   - Web Interface: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
