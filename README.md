# E-commerce API

API REST develop with Spring Boot to manage a simple shopping cart.

## Tecnologies Utilized

- Java 21
- Spring Boot 3.4.3
- Maven
- JUnit 5
- Swagger/OpenAPI
- Lombok

## Features

- CRUD management of shopping carts
- Carts can have one or more products
- Automatic expiration of inactive carts (10 minutes)
- API documentation with Swagger
- Unit tests

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

## Installation

1. Clone the repository:

```bash
git clone https://github.com/tu-usuario/ecomerce-onebox.git
cd ecomerce-onebox
```

2. Run the application:

```bash
mvn spring-boot:run
```

3. Access the API documentation:

```bash
http://localhost:8080/swagger-ui/index.html
```

## API Endpoints

### Carts

- `POST /Carts` - Create a new cart
- `GET /Carts/{id}` - Get a cart by ID
- `GET /Carts` - Get all carts
- `POST /Carts/{id}/products` - Add product to cart
- `DELETE /Carts/{id}` - Delete a cart

### Products -> disabled controller

- `GET /products` - Get all products
- `GET /products/{id}` - Get a product by ID
- `POST /products` - Create a new product
- `PUT /products/{id}` - Update an existing product
- `DELETE /products/{id}` - Delete a product

## API Documentation

The API documentation is available through Swagger UI:

## Tests

To run the tests:
```bash
mvn test
```

### Cobertura de Tests

The tests include:
- Unit tests for ProductService
- Unit tests for CartService
- Validation of cart expiration
- Error handling

## Special Features

- Automatic expiration of carts after 1 minute of inactivity
- Concurrent cart management using ConcurrentHashMap
- Input data validation
- Custom error handling

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/ecomerce_onebox/test/
│   │       ├── controllers/
│   │       ├── entities/
│   │       ├── service/
│   │       └── TestApplication.java
│   └── resources/
└── test/
    └── java/
        └── com/ecomerce_onebox/test/
            └── service/
```

## Contribuir

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Contact

Andres - feliperamirez@gmail.com

Link del proyecto: https://github.com/AndresFelipeRamirez/test-onebox
