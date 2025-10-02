# Spring Boot AOP Example

This is a comprehensive example demonstrating Aspect-Oriented Programming (AOP) in Spring Boot.

## What is AOP?

Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns. It does so by adding additional behavior to existing code without modifying the code itself.

## Project Structure

```
├── src/
│   ├── main/
│   │   ├── java/com/example/aop/
│   │   │   ├── AopExampleApplication.java  # Main Spring Boot application
│   │   │   ├── UserService.java            # Service class with business logic
│   │   │   └── LoggingAspect.java          # Aspect class with AOP advice
│   │   └── resources/
│   │       └── application.properties      # Application configuration
│   └── test/
│       └── java/com/example/aop/
│           └── AopExampleApplicationTests.java  # Unit tests
└── pom.xml                                  # Maven configuration
```

## Key Concepts Demonstrated

### 1. Aspect (`@Aspect`)
The `LoggingAspect` class demonstrates how to create an aspect that intercepts method calls.

### 2. AOP Advice Types

- **@Before**: Executes before the method execution
- **@After**: Executes after the method execution (regardless of outcome)
- **@AfterReturning**: Executes after successful method execution
- **@AfterThrowing**: Executes if method throws an exception
- **@Around**: Wraps method execution and can control when/if the method executes

### 3. Pointcut Expressions
Example: `execution(* com.example.aop.UserService.*(..))`
- First `*`: Any return type
- `com.example.aop.UserService`: Target class
- Second `*`: Any method name
- `(..)`: Any number of parameters

## Prerequisites

- Java 11 or higher
- Maven 3.6+

## How to Run

### 1. Build the project
```bash
mvn clean install
```

### 2. Run the application
```bash
mvn spring-boot:run
```

### 3. Run tests
```bash
mvn test
```

## Expected Output

When you run the application, you'll see AOP in action with logging output showing:
- Method execution tracking
- Method arguments logging
- Execution time measurement
- Exception handling

Example output:
```
===== Calling createUser() =====
[BEFORE] Executing: createUser
[BEFORE] Method arguments: 
  arg[0]: John Doe
  arg[1]: john@example.com
Creating user: John Doe with email: john@example.com
[AFTER RETURNING] Method: createUser
[AFTER] Completed: createUser

===== Calling getUserById() =====
[AROUND - START] Method: getUserById
[BEFORE] Executing: getUserById
[BEFORE] Method arguments: 
  arg[0]: 1
Fetching user with ID: 1
[AFTER RETURNING] Method: getUserById
[AFTER RETURNING] Return value: User-1
[AFTER] Completed: getUserById
[AROUND - END] Method: getUserById
[AROUND - END] Execution time: 5ms
```

## Key Files Explained

### LoggingAspect.java
Contains all AOP advice implementations:
- Logs method execution
- Tracks execution time
- Handles exceptions
- Logs method arguments and return values

### UserService.java
A simple service class with CRUD-like methods that serve as targets for AOP interceptors.

### AopExampleApplication.java
The main application that demonstrates AOP functionality by calling various service methods.

## Learning Points

1. **Separation of Concerns**: Logging logic is separated from business logic
2. **Code Reusability**: One aspect can apply to multiple methods
3. **Non-Invasive**: Business logic code doesn't need to be modified for logging
4. **Flexibility**: Easy to enable/disable or modify cross-cutting concerns

## Further Reading

- [Spring AOP Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)
- [AspectJ Documentation](https://www.eclipse.org/aspectj/doc/released/progguide/index.html)
