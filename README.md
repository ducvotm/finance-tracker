# Personal Finance Tracker with AI Insights (MVP)

A simple yet powerful personal finance management application built with Java and Spring Boot that tracks financial transactions and provides basic AI-powered insights to help improve financial habits.

## Overview

This MVP application allows users to record their financial transactions, organize them into categories, and receive AI-generated insights about their spending patterns. It serves as a practical demonstration of core Spring technologies while solving a real-world problem.

## Core Features

### Transaction Management
- Record basic income and expenses
- Store essential transaction details (amount, date, description, category)
- View transaction history

### Category Management
- Organize transactions into predefined categories
- Create custom categories

### AI-Powered Basic Insights
- Receive simple spending pattern analysis
- Get basic recommendations for potential savings
- View monthly spending summaries

## Technical Stack

### Backend
- **Java 17**: Core programming language
- **Spring Boot 3.2.x**: Application framework
- **Spring Data JPA**: Data access layer
- **Spring Security**: Basic authentication and authorization
- **Spring Boot Actuator**: Essential monitoring endpoints
- **H2 Database**: In-memory database for development
- **JUnit 5**: Testing framework
- **OpenAI API**: Powers basic AI insights

## Project Structure

```
src/main/java/com/yourname/financetracker/
│
├── FinanceTrackerApplication.java       // Main application class
│
├── config/                              // Configuration classes
│   ├── SecurityConfig.java              // Basic security setup
│   └── AIServiceConfig.java             // AI service configuration
│
├── model/                               // JPA entity classes
│   ├── User.java                        // Basic user model
│   ├── Transaction.java                 // Transaction model
│   ├── Category.java                    // Category model
│   └── AIInsight.java                   // Insight model
│
├── repository/                          // Spring Data repositories
│   ├── UserRepository.java
│   ├── TransactionRepository.java
│   ├── CategoryRepository.java
│   └── AIInsightRepository.java
│
├── service/                             // Business logic
│   ├── UserService.java
│   ├── TransactionService.java
│   ├── CategoryService.java
│   └── AIInsightService.java
│
├── controller/                          // REST controllers
│   ├── AuthController.java
│   ├── TransactionController.java
│   ├── CategoryController.java
│   └── AIInsightController.java
│
└── util/                                // Utility classes
    └── AIPromptGenerator.java
```

## Learning Objectives Covered

This MVP project demonstrates essential Spring ecosystem capabilities:

1. **Spring Configuration**: Uses Java Configuration and annotations for application setup.

2. **Testing**: Includes basic unit and integration tests with JUnit 5.

3. **Spring Data Access**: Implements data access using Spring Data JPA.

4. **Spring Boot**: Uses Spring Boot to simplify application development.

5. **Auto-configuration and Properties**: Leverages Spring Boot's auto-configuration capabilities.

6. **REST API**: Implements a simple REST API for core application functions.

7. **Spring Security**: Provides basic authentication and authorization.

8. **Monitoring**: Uses Spring Boot Actuator for essential health checks and metrics.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- OpenAI API key (for AI insights feature)

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/personal-finance-tracker.git
   cd personal-finance-tracker
   ```

2. Configure application properties in `src/main/resources/application.properties`:
   ```
   # H2 Database Configuration
   spring.datasource.url=jdbc:h2:mem:financedb
   spring.datasource.username=sa
   spring.datasource.password=
   spring.h2.console.enabled=true
   
   # OpenAI API Configuration
   openai.api.key=your_openai_api_key
   
   # JWT Configuration
   jwt.secret=your_jwt_secret
   jwt.expiration=86400000
   ```

3. Build and run the application:
   ```
   mvn spring-boot:run
   ```

The application will be accessible at `http://localhost:8080`.

## Core API Endpoints

| Method | URL                       | Description                          |
|--------|---------------------------|--------------------------------------|
| POST   | /api/auth/register        | Register a new user                  |
| POST   | /api/auth/login           | Authenticate a user                  |
| GET    | /api/transactions         | Get user's transactions              |
| POST   | /api/transactions         | Create a new transaction             |
| GET    | /api/categories           | Get available categories             |
| GET    | /api/insights             | Get basic AI-generated insights      |

## Future Enhancements

After completing the MVP, the application can be extended with:

- Budget planning and tracking
- Transaction import from bank statements
- Advanced reporting and visualization
- Investment tracking
- Financial goal setting

## License

This project is licensed under the MIT License.