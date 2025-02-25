# E-commerce API

API REST desarrollada con Spring Boot para gestionar un carrito de compras simple.

## Tecnologías Utilizadas

- Java 21
- Spring Boot 3.4.3
- Maven
- JUnit 5
- Swagger/OpenAPI
- Lombok

## Características

- Gestión de carritos de compra CRUD
- Los carritos pueden tener uno o mas productos
- Expiración automática de carritos inactivos (10 minutos)
- Documentación API con Swagger
- Tests unitarios

## Requisitos Previos

- Java 21 o superior
- Maven 3.6 o superior

## Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/tu-usuario/ecomerce-onebox.git
cd ecomerce-onebox
```

2. Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

3. Acceder a la documentación de la API:

```bash
http://localhost:8080/swagger-ui/index.html
```

## Endpoints API

### Carritos

- `POST /Carts` - Crear un nuevo carrito
- `GET /Carts/{id}` - Obtener un carrito por ID
- `GET /Carts` - Obtener todos los carritos
- `POST /Carts/{id}/products` - Añadir producto al carrito
- `DELETE /Carts/{id}` - Eliminar un carrito

### Productos -> controllador desahabilitado

- `GET /products` - Obtener todos los productos
- `GET /products/{id}` - Obtener un producto por ID
- `POST /products` - Crear un nuevo producto
- `PUT /products/{id}` - Actualizar un producto existente
- `DELETE /products/{id}` - Eliminar un producto

## Documentación API

La documentación de la API está disponible a través de Swagger UI:

## Tests

Para ejecutar los tests:
```bash
mvn test
```

### Cobertura de Tests

Los tests incluyen:
- Tests unitarios para ProductService
- Tests unitarios para CartService
- Validación de la expiración de carritos
- Manejo de casos de error

## Características Especiales

- Expiración automática de carritos después de 1 minuto de inactividad
- Gestión concurrente de carritos usando ConcurrentHashMap
- Validación de datos de entrada
- Manejo de errores personalizado

## Estructura del Proyecto

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

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia

[Tipo de Licencia] - ver el archivo LICENSE.md para más detalles

## Contacto

[Andres] - [feliperamirez@gmail.com]

Link del proyecto: [https://github.com/AndresFelipeRamirez/test-onebox]