# API REST de Productos con Java y Spring Boot

Este proyecto es una API RESTful desarrollada con Java y el framework Spring Boot. La API gestiona una colección de "Productos" y expone endpoints para las operaciones CRUD (Crear, Leer, Actualizar, Borrar).

El objetivo principal es demostrar la creación de un backend robusto y escalable utilizando tecnologías estándar en el ecosistema empresarial de Java.

## Características

*   **API RESTful completa:** Endpoints para `GET`, `POST`, `PUT` y `DELETE`.
*   **Persistencia de Datos:** Utiliza Spring Data JPA para interactuar con una base de datos.
*   **Base de Datos en Memoria:** Configurado con H2, una base de datos en memoria ideal para desarrollo y pruebas que no requiere instalación.
*   **Consola de Base de Datos:** Incluye una consola web para H2 que permite visualizar y manipular los datos directamente desde el navegador.
*   **Inyección de Dependencias:** Sigue las mejores prácticas de Spring para gestionar los componentes de la aplicación.

## Tecnologías Utilizadas

*   **Lenguaje:** **Java 17**
*   **Framework Principal:** **Spring Boot 3**
*   **Dependencias Clave:**
    *   **Spring Web:** Para construir APIs REST.
    *   **Spring Data JPA:** Para el acceso a datos y la persistencia (ORM).
    *   **H2 Database:** Como base de datos en memoria.
*   **Gestor de Construcción:** **Maven**

## Cómo Ejecutar el Proyecto

**1. Prerrequisitos:**
   *   Tener instalado el **JDK (Java Development Kit) 17** o superior.
   *   Tener instalado **Apache Maven**.

**2. Clonar y Construir:**

   ```bash
   # 1. Clona el repositorio
   git clone https://github.com/tu-usuario/product-api-spring.git
   cd product-api-spring

   # 2. Construye el proyecto con Maven
   # Esto descargará todas las dependencias y compilará el código
   mvn clean install
   ```

**3. Ejecutar la Aplicación:**

   Una vez construido el proyecto, puedes ejecutarlo de dos maneras:

   *   **Usando Maven:**
     ```bash
     mvn spring-boot:run
     ```
   *   **Ejecutando el archivo JAR (Recomendado ):**
     ```bash
     java -jar target/product-api-0.0.1-SNAPSHOT.jar
     ```

   La API estará funcionando en `http://localhost:8080`.

## Endpoints de la API

La URL base para todos los endpoints es `/api/products`.

| Método   | Endpoint          | Descripción                               | Body (JSON ) de Ejemplo                               |
|----------|-------------------|-------------------------------------------|------------------------------------------------------|
| `GET`    | `/`               | Obtiene la lista de todos los productos.  | N/A                                                  |
| `GET`    | `/{id}`           | Obtiene un producto por su ID.            | N/A                                                  |
| `POST`   | `/`               | Crea un nuevo producto.                   | `{"name": "Laptop", "price": 1200.50}`               |
| `PUT`    | `/{id}`           | Actualiza un producto existente.          | `{"name": "Laptop Gamer", "price": 1500.75}`         |
| `DELETE` | `/{id}`           | Elimina un producto por su ID.            | N/A                                                  |

## Acceso a la Consola H2

Mientras la aplicación está en ejecución, puedes acceder a una consola web para ver la base de datos en memoria.
*   **URL:** `http://localhost:8080/h2-console`
*   **JDBC URL:** `jdbc:h2:mem:productdb`
*   **User Name:** `sa`
*   **Password:** (dejar en blanco )

---
*Desarrollado por David Arenas Cabeza.*
