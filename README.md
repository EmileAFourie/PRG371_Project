# Spring Boot User Registration and Authentication System for Belgium Campus ITversity

The Spring Boot User Registration and Authentication System is a web application that provides user registration, authentication, and administration functionalities. This application is built using the Spring Boot framework, providing a robust and secure foundation for user management.

## Features

- User Registration: New users can sign up using their email address and password.
- User Authentication: Registered users can log in using their credentials.
- User Administration (Admin Role):
  - View Users: Admins can view a list of all registered users.
  - Add Users: Admins can add new users to the system.
  - Edit Users: Admins can edit user information.
  - Delete Users: Admins can remove users from the system.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven
- MySQL Database
- Internet Browser

## Getting Started

1. **Clone the Repository:** Clone this repository to your local machine using Git.

   ```bash
   git clone https://github.com/yourusername/spring-user-authentication.git
   ```

2. **Database Setup:** Create a MySQL database for the application. Update the `application.properties` file in the `src/main/resources` directory with your database configuration. [do we just add our db here?]

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   ```

3. **Build and Run:** Navigate to the project directory and build the application using Maven.

   ```bash
   cd spring-user-authentication
   mvn clean install
   ```

   Run the application using the following command:

   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application:** Open your web browser and navigate to `http://localhost:8080` to access the application.

## Usage

### User Registration

1. Click the "Sign Up" button on the home page.
2. Fill in the required registration information, including email and password.
3. Click "Register" to create a new user account.
[to be updated]

### User Authentication

1. On the home page, click the "Login" button.
2. Enter your registered email and password.
3. Click "Login" to access your account.
[to be updated]

### Admin Functionalities

1. Login using an admin account.
2. Once logged in as an admin, you can access the admin panel.
3. In the admin panel, you can view, add, edit, and delete user accounts.
[to be updated]

## Security Considerations

- Ensure that sensitive information, such as database credentials, is kept secure.
- Implement password hashing and salting for enhanced user password security.
- Use Spring Security features to prevent unauthorized access to admin functionalities.

## Contributing

Contributions are welcome! Feel free to submit a pull request if you find any issues or want to add new features.

## License

This project is licensed under the [MIT License](LICENSE).

---

**Note:** [placeholder]
