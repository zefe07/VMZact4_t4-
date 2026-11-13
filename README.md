# Actividad 4: API REST con Spring Boot, Spring Security y JWT

Este proyecto implementa una API REST completa y protegida, utilizando **Spring Boot**, **Spring Data JPA**, **MySQL** y autenticación real mediante **JWT (JSON Web Tokens)** con **Spring Security**. Las pruebas fueron realizadas con la herramienta **Bruno**.

## 🛠️ Tecnologías utilizadas
* Java 25 / Spring Boot 4.1.2
* Spring Security + JWT (Autenticación y autorización)
* Spring Data JPA + MySQL (Persistencia de datos)
* Bean Validation (Validación de DTOs)
* Bruno (Colección de peticiones incluida en la carpeta `/bruno`)

## ✨ Características implementadas
* **Autenticación real:** Endpoints `/api/auth/register` y `/api/auth/login` que generan un token JWT real.
* **Seguridad:** Filtro (`JwtAuthenticationFilter`) que valida el token en cada petición. Las rutas del CRUD están protegidas.
* **DTOs:** Uso de `RegisterRequestDTO`, `LoginRequestDTO`, `ProductoDTO`, etc., para no exponer entidades directamente.
* **Validación:** Uso de `@Valid`, `@NotBlank`, `@Positive` para validar datos de entrada.
* **Códigos HTTP apropiados:** Uso de `ResponseEntity` para devolver 200, 201, 403, 404.
* **Colección de Bruno:** Incluida en la carpeta `/bruno` del repositorio.

---

## 📸 Evidencia de Funcionamiento (Pruebas en Bruno)

### 1. Login (Obtención del Token)
*Petición POST al endpoint `/api/auth/login`. Devuelve un JWT real.*
[PEGA AQUÍ LA CAPTURA DE BRUNO DEL LOGIN EXITOSO]

### 2. Prueba sin token (Rechazado por Seguridad)
*Petición GET a `/api/productos` sin token. Spring Security bloquea el acceso con un 403 Forbidden.*
[PEGA AQUÍ LA CAPTURA DEL 403 FORBIDDEN (puede ser la del navegador o la de Bruno)]

### 3. CRUD Protegido (Con Token)
*Petición POST para crear un producto usando el token en la cabecera Authorization (Bearer Token).*
[PEGA AQUÍ LA CAPTURA DE BRUNO DEL POST CREANDO UN PRODUCTO (201 Created)]

[PEGA AQUÍ LA CAPTURA DE BRUNO DEL GET LISTANDO LOS PRODUCTOS (200 OK)]

---

## 🚀 Despliegue en el VPS
El proyecto se encuentra desplegado y funcionando en el VPS de AWS, en el puerto **8086**, conectado a una base de datos MySQL en el servidor:

* **URL Base de la API:** `http://77.113.100.81:8086`
* **Endpoint de Productos:** `http://77.113.100.81:8086/api/productos`

*(Nota: Al entrar desde el navegador, la API devuelve un 403 Forbidden porque está protegida por Spring Security. Para probarla, importa la colección de Bruno y usa el token JWT generado en el login).*

## 📂 Estructura del Proyecto
* `src/main/java`: Código fuente (Controladores, Servicios, Repositorios, Modelos, DTOs, Seguridad).
* `src/main/resources`: Configuración de la aplicación.
* `bruno/`: Colección de peticiones para probar la API (registro, login, CRUD).# Actividad 4: API REST con Spring Boot, Spring Security y JWT

Este proyecto implementa una API REST completa y protegida, utilizando **Spring Boot**, **Spring Data JPA**, **MySQL** y autenticación real mediante **JWT (JSON Web Tokens)** con **Spring Security**. Las pruebas fueron realizadas con la herramienta **Bruno**.

## 🛠️ Tecnologías utilizadas
* Java 25 / Spring Boot 4.1.2
* Spring Security + JWT (Autenticación y autorización)
* Spring Data JPA + MySQL (Persistencia de datos)
* Bean Validation (Validación de DTOs)
* Bruno (Colección de peticiones incluida en la carpeta `/bruno`)

## ✨ Características implementadas
* **Autenticación real:** Endpoints `/api/auth/register` y `/api/auth/login` que generan un token JWT real.
* **Seguridad:** Filtro (`JwtAuthenticationFilter`) que valida el token en cada petición. Las rutas del CRUD están protegidas.
* **DTOs:** Uso de `RegisterRequestDTO`, `LoginRequestDTO`, `ProductoDTO`, etc., para no exponer entidades directamente.
* **Validación:** Uso de `@Valid`, `@NotBlank`, `@Positive` para validar datos de entrada.
* **Códigos HTTP apropiados:** Uso de `ResponseEntity` para devolver 200, 201, 403, 404.
* **Colección de Bruno:** Incluida en la carpeta `/bruno` del repositorio.

---



## 🚀 Despliegue en el VPS
El proyecto se encuentra desplegado y funcionando en el VPS de AWS, en el puerto **8086**, conectado a una base de datos MySQL en el servidor:

* **URL Base de la API:** `http://77.113.100.81:8086`
* **Endpoint de Productos:** `http://77.113.100.81:8086/api/productos`

*(Nota: Al entrar desde el navegador, la API devuelve un 403 Forbidden porque está protegida por Spring Security. Para probarla, importa la colección de Bruno y usa el token JWT generado en el login).*

## 📂 Estructura del Proyecto
* `src/main/java`: Código fuente (Controladores, Servicios, Repositorios, Modelos, DTOs, Seguridad).
* `src/main/resources`: Configuración de la aplicación.
* `bruno/`: Colección de peticiones para probar la API (registro, login, CRUD).# Actividad 4: API REST con Spring Boot, Spring Security y JWT

Este proyecto implementa una API REST completa y protegida, utilizando **Spring Boot**, **Spring Data JPA**, **MySQL** y autenticación real mediante **JWT (JSON Web Tokens)** con **Spring Security**. Las pruebas fueron realizadas con la herramienta **Bruno**.

## 🛠️ Tecnologías utilizadas
* Java 25 / Spring Boot 4.1.2
* Spring Security + JWT (Autenticación y autorización)
* Spring Data JPA + MySQL (Persistencia de datos)
* Bean Validation (Validación de DTOs)
* Bruno (Colección de peticiones incluida en la carpeta `/bruno`)

## ✨ Características implementadas
* **Autenticación real:** Endpoints `/api/auth/register` y `/api/auth/login` que generan un token JWT real.
* **Seguridad:** Filtro (`JwtAuthenticationFilter`) que valida el token en cada petición. Las rutas del CRUD están protegidas.
* **DTOs:** Uso de `RegisterRequestDTO`, `LoginRequestDTO`, `ProductoDTO`, etc., para no exponer entidades directamente.
* **Validación:** Uso de `@Valid`, `@NotBlank`, `@Positive` para validar datos de entrada.
* **Códigos HTTP apropiados:** Uso de `ResponseEntity` para devolver 200, 201, 403, 404.
* **Colección de Bruno:** Incluida en la carpeta `/bruno` del repositorio.

---

## 📸 Evidencia de Funcionamiento (Pruebas en Bruno)

### 1. Login (Obtención del Token)
*Petición POST al endpoint `/api/auth/login`. Devuelve un JWT real.*
<img width="1460" height="403" alt="Captura de pantalla 2026-11-12 181155" src="https://github.com/user-attachments/assets/325b96b7-33b5-4812-8bb7-c9c8707b2dcf" />

### 2. Prueba sin token (Rechazado por Seguridad)
*Petición GET a `/api/productos` sin token. Spring Security bloquea el acceso con un 403 Forbidden.*
<img width="1451" height="388" alt="image" src="https://github.com/user-attachments/assets/c7f42a3f-9307-4ab3-a10c-532681b71ec7" />

### 3. CRUD Protegido (Con Token)
*Petición POST para crear un producto usando el token en la cabecera Authorization (Bearer Token).*
<img width="1456" height="422" alt="image" src="https://github.com/user-attachments/assets/7c2533c0-65e5-431d-8824-3494360d3bd0" />

<img width="1457" height="527" alt="image" src="https://github.com/user-attachments/assets/54727cd1-06c0-41c9-8095-599f082e4189" />

---

## 🚀 Despliegue en el VPS
El proyecto se encuentra desplegado y funcionando en el VPS de AWS, en el puerto **8086**, conectado a una base de datos MySQL en el servidor:

* **URL Base de la API:** `http://77.113.100.81:8086`
* **Endpoint de Productos:** `http://77.113.100.81:8086/api/productos`

*(Nota: Al entrar desde el navegador, la API devuelve un 403 Forbidden porque está protegida por Spring Security. Para probarla, importa la colección de Bruno y usa el token JWT generado en el login).*

## 📂 Estructura del Proyecto
* `src/main/java`: Código fuente (Controladores, Servicios, Repositorios, Modelos, DTOs, Seguridad).
* `src/main/resources`: Configuración de la aplicación.
* `bruno/`: Colección de peticiones para probar la API (registro, login, CRUD).
