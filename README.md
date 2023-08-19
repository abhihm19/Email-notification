# Email-notification
Spring Boot project for sending Email notification using org.apache.velocity library.

This repository contains a basic Spring Boot application that demonstrates how to send emails using Velocity templates. Velocity is a template engine that allows you to generate dynamic content, such as email bodies, using templates.

## Getting Started:

To get started with this example, follow the steps outlined below.

## Prerequisites:

- Java Development Kit (JDK) 8 or later
- Maven

## Setup:

1. Clone this repository:

   `git clone https://github.com/abhihm19/Email-notification.git`

2. Navigate to the project directory:

   `cd Email-notification`

3. Open src/main/resources/application.properties and configure the following properties:

   - spring.mail.host=your-smtp-host
   - spring.mail.port=587
   - spring.mail.username=your-username
   - spring.mail.password=your-password

   Replace your-smtp-host, your-username, and your-password with your actual SMTP server details and credentials.

4. Run the application:

   `mvn spring-boot:run`

## Usage:

1. Once the application is running, open your web browser or API client.

2. Access the /send-email endpoint with the following query parameters:
   - name: Recipient's name.

   Example: http://localhost:8080/send-email/John

3. You should see a success message if the email is sent successfully.

## Configuration:

The application uses Velocity templates for generating email content. The template can be found at src/main/resources/templates/email-template.vm. You can customize the template to match your requirements.

## Contributing:

Contributions are welcome! If you find any issues or want to enhance this example, feel free to open an issue or create a pull request.

## License:

This project is an open source project.
