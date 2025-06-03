# Spring Boot Thymeleaf Demo

This repository is a learning project demonstrating how to build a modern web application using **Spring Boot** and **Thymeleaf** with Kotlin. It showcases best practices for structuring templates, using layouts, and organizing code in a professional, enterprise-ready way.

## Features

- Spring Boot 3 with Kotlin
- Thymeleaf template engine
- Tailwind CSS for modern styling
- Thymeleaf Layout Dialect for DRY, maintainable templates
- Custom beans and services
- Static resource management (CSS)
- Professional layout with navigation and footer

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── kotlin/com/example/demo/        # Kotlin source code
│   │   └── resources/
│   │       ├── static/css/                 # CSS files (Tailwind)
│   │       └── templates/                  # Thymeleaf templates
│   └── test/kotlin/com/example/demo/       # Tests
├── pom.xml                                # Maven build file
└── README.md
```

## How to Run

1. **Clone the repository:**
   ```bash
   git clone <repo-url>
   cd demo
   ```
2. **Install Node.js dependencies (for Tailwind):**
   ```bash
   npm install
   ```
3. **Start Tailwind in watch mode (recommended during development):**
   ```bash
   npm run watch:css
   ```
   This will automatically rebuild your CSS when you change HTML or Tailwind classes.
4. **Build the project:**
   ```bash
   ./mvnw clean install
   ```
5. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
6. **Open in your browser:**
   - Home: [http://localhost:8080/](http://localhost:8080/)
   - About: [http://localhost:8080/about](http://localhost:8080/about)
   - Contact: [http://localhost:8080/contact](http://localhost:8080/contact)

## Development Workflow with Tailwind CSS

- Use `npm run watch:css` to keep your Tailwind CSS up-to-date as you edit templates.
- For a one-time build (e.g., before deployment), use `npm run build:css`.

## Learning Highlights

- How to use Tailwind CSS and Thymeleaf layouts for shared navigation, footer, and styling
- How to organize static resources and templates in a Spring Boot project
- How to create and inject custom beans in Kotlin

## License

This project is for learning and demonstration purposes.
