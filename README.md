# DemandasCiudadanas API

A REST API backend for managing citizen demands and complaints in a municipal government context. The system supports the full lifecycle of a citizen request — from submission and classification, through workflow routing, to resolution and case closure.

## Table of Contents

- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [API Reference](#api-reference)
- [Data Models](#data-models)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)

---

## Overview

**DemandasCiudadanas API** provides a backend service to:

- Register and track **citizen demands** (complaints, requests, incidents) with geolocation and priority data.
- Manage **users** with role-based access and authentication.
- Handle **case files (expedientes)** linked to demands, tracking opening date, status, and resolution.
- Define **typologies and subtypologies** to categorise demands.
- Model **organisational areas**, **workflows (flujos)**, and **state transitions** to route demands through a configurable processing pipeline.

The API is designed to work alongside an Angular frontend (default: `http://localhost:4200`).

---

## Technology Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.4.0 |
| Web | Spring Web (REST) |
| Database | MongoDB |
| Data Access | Spring Data MongoDB |
| Build Tool | Maven 3.9.9 (wrapper included) |
| Utilities | Lombok |
| Testing | JUnit Jupiter (Spring Boot Test) |

---

## Architecture

The project follows a standard **layered architecture**:

```
HTTP Request
     │
     ▼
┌─────────────┐
│  Controller │  REST endpoints — routes requests, returns HTTP responses
└──────┬──────┘
       │
       ▼
┌─────────────┐
│   Service   │  Business logic — CRUD operations and custom rules
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ Repository  │  Data access — Spring Data MongoDB interfaces
└──────┬──────┘
       │
       ▼
┌─────────────┐
│   MongoDB   │  Document storage
└─────────────┘
```

DTOs are used to decouple the API contract from internal entity models.

---

## Prerequisites

- **Java 17** or higher
- **MongoDB** running on `localhost:27017` (or configured instance)
- **Maven 3.9.9** (or use the included Maven wrapper — no separate install needed)

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/CarlosA21/DemandasCiudadanas.git
cd DemandasCiudadanas
```

### 2. Start MongoDB

```bash
# Local instance
mongod

# Or with Docker
docker run -d -p 27017:27017 --name mongo mongo:latest
```

### 3. Build and run

**Unix / macOS:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

The API will be available at:

```
http://localhost:8080/demandasAPI/api/
```

### 4. Build a deployable JAR

```bash
./mvnw clean package
java -jar target/demandasAPI-0.0.1-SNAPSHOT.jar
```

---

## Configuration

All configuration is in `src/main/resources/application.properties`:

```properties
spring.application.name=demandasAPI
server.servlet.context-path=/demandasAPI

spring.data.mongodb.uri=mongodb://localhost:27017/DemandasCiudadanas
spring.data.mongodb.database=DemandasCiudadanas
```

| Property | Default | Description |
|---|---|---|
| `server.servlet.context-path` | `/demandasAPI` | API base context path |
| `spring.data.mongodb.uri` | `mongodb://localhost:27017/DemandasCiudadanas` | MongoDB connection string |
| `spring.data.mongodb.database` | `DemandasCiudadanas` | Target database name |

**CORS** is configured in `CorsConfig.java` and allows requests from `http://localhost:4200` (Angular dev server) using `GET`, `POST`, `PUT`, `DELETE`, and `OPTIONS` methods.

---

## API Reference

**Base URL:** `http://localhost:8080/demandasAPI/api`

All endpoints follow the same CRUD pattern. Responses use standard HTTP status codes.

---

### Demands — `/demanda`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/demanda` | Create a new demand |
| `GET` | `/demanda` | List all demands |
| `GET` | `/demanda/{id}` | Get demand by ID |
| `PUT` | `/demanda/{id}` | Update demand |
| `DELETE` | `/demanda/{id}` | Delete demand |

**Create demand — request body:**
```json
{
  "tipologia": 1,
  "demandante": 1,
  "clasificacion": "Infrastructure",
  "descripcion": "Pothole on Main Street",
  "latitud": -34.6037,
  "longitud": -58.3816,
  "prioridad": 3
}
```

---

### Users — `/usuarios`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/usuarios` | Create a new user |
| `GET` | `/usuarios` | List all users |
| `GET` | `/usuarios/{id}` | Get user by ID |
| `PUT` | `/usuarios/{id}` | Update user |
| `DELETE` | `/usuarios/{id}` | Delete user |
| `POST` | `/usuarios/login` | Authenticate user |

**Create user — request body:**
```json
{
  "nombre": "Carlos",
  "apellido": "Ariel",
  "documento": 12345678,
  "Barrio": "Centro",
  "Domicilio": "Av. San Martín 100",
  "email": "carlos@example.com",
  "Clave": "secret123",
  "Rol": "ADMIN"
}
```

**Login — request body:**
```json
{
  "email": "carlos@example.com",
  "Clave": "secret123"
}
```

---

### Case Files — `/expedientes`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/expedientes` | Create a new case file |
| `GET` | `/expedientes` | List all case files |
| `GET` | `/expedientes/{id}` | Get case file by ID |
| `PUT` | `/expedientes/{id}` | Update case file |
| `DELETE` | `/expedientes/{id}` | Delete case file |

---

### States — `/estado`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/estado` | Create a new state |
| `GET` | `/estado` | List all states |
| `GET` | `/estado/{id}` | Get state by ID |
| `PUT` | `/estado/{id}` | Update state |
| `DELETE` | `/estado/{id}` | Delete state |

---

### Areas — `/area`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/area` | Create a new area |
| `GET` | `/area` | List all areas |
| `GET` | `/area/{id}` | Get area by ID |
| `PUT` | `/area/{id}` | Update area |
| `DELETE` | `/area/{id}` | Delete area |

---

### Typologies — `/tipologia`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/tipologia` | Create a new typology |
| `GET` | `/tipologia` | List all typologies |
| `GET` | `/tipologia/{id}` | Get typology by ID |
| `PUT` | `/tipologia/{id}` | Update typology |
| `DELETE` | `/tipologia/{id}` | Delete typology |

---

### Subtypologies — `/subtipologia`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/subtipologia` | Create a new subtypology |
| `GET` | `/subtipologia` | List all subtypologies |
| `GET` | `/subtipologia/{id}` | Get subtypology by ID |
| `PUT` | `/subtipologia/{id}` | Update subtypology |
| `DELETE` | `/subtipologia/{id}` | Delete subtypology |

---

### Workflows — `/flujo`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/flujo` | Create a new workflow |
| `GET` | `/flujo` | List all workflows |
| `GET` | `/flujo/{id}` | Get workflow by ID |
| `PUT` | `/flujo/{id}` | Update workflow |
| `DELETE` | `/flujo/{id}` | Delete workflow |

---

### Transitions — `/transicion`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/transicion` | Create a new transition |
| `GET` | `/transicion` | List all transitions |
| `GET` | `/transicion/{id}` | Get transition by ID |
| `PUT` | `/transicion/{id}` | Update transition |
| `DELETE` | `/transicion/{id}` | Delete transition |

---

## Data Models

### Usuario (User)
| Field | Type | Description |
|---|---|---|
| `id` | String (ObjectId) | Auto-generated identifier |
| `nombre` | String | First name |
| `apellido` | String | Last name |
| `documento` | Integer | National ID number |
| `Barrio` | String | Neighbourhood |
| `Domicilio` | String | Address |
| `email` | String | Unique email (used for login) |
| `Clave` | String | Password |
| `Rol` | String | Role (e.g., `ADMIN`) |

### Demanda (Demand)
| Field | Type | Description |
|---|---|---|
| `id_demanda` | String (ObjectId) | Auto-generated identifier |
| `tipologia` | Integer | Typology ID |
| `demandante` | Integer | Requesting user ID |
| `clasificacion` | String | Classification label |
| `descripcion` | String | Description of the demand |
| `latitud` | Float | Latitude |
| `longitud` | Float | Longitude |
| `prioridad` | Integer | Priority level |

### Expediente (Case File)
| Field | Type | Description |
|---|---|---|
| `id_expediente` | String (ObjectId) | Auto-generated identifier |
| `Demanda` | Integer | Linked demand ID |
| `caratula` | String | Case heading/title |
| `estado` | Integer | Current state ID |
| `apertura` | LocalDate | Opening date |
| `cierre` | LocalDate | Closing date |
| `resolucion` | String | Resolution notes |

### Area
| Field | Type | Description |
|---|---|---|
| `id_area` | String (ObjectId) | Auto-generated identifier |
| `nombre` | String | Area name |
| `usuarios` | String | Associated user IDs |
| `referente` | Integer | Referent/manager user ID |
| `siguienteSubArea` | Integer | Next sub-area ID |

### Estado (State)
| Field | Type | Description |
|---|---|---|
| `id_estado` | String (ObjectId) | Auto-generated identifier |
| `Situacion` | String | Situation description |
| `Estado` | String | State label (e.g., `Pendiente`, `Resuelto`) |

### Tipologia (Typology)
| Field | Type | Description |
|---|---|---|
| `id_tipologia` | String (ObjectId) | Auto-generated identifier |
| `tipologia` | String | Type name |
| `descripcion` | String | Description |
| `SubTipologia` | Integer | Related subtypology ID |

### Subtipologia (Subtypology)
| Field | Type | Description |
|---|---|---|
| `id_subtipologia` | String (ObjectId) | Auto-generated identifier |
| `SiguienteSubTip` | Integer | Next subtypology ID |

### Flujo (Workflow)
| Field | Type | Description |
|---|---|---|
| `id_flujo` | String (ObjectId) | Auto-generated identifier |
| `nombre` | String | Workflow name |
| `Descripcion` | String | Description |
| `Area` | Integer | Associated area ID |
| `actividades` | String | Activity list |

### Transicion (Transition)
| Field | Type | Description |
|---|---|---|
| `id_transicion` | String (ObjectId) | Auto-generated identifier |
| `Responsable` | Integer | Responsible party ID |
| `Estado` | Integer | Target state ID |
| `lista` | String | Queue/list identifier |

---

## Running Tests

```bash
# Unix / macOS
./mvnw test

# Windows
mvnw.cmd test
```

---

## Project Structure

```
DemandasCiudadanas/
├── mvnw / mvnw.cmd               # Maven wrapper scripts
├── pom.xml                       # Maven build configuration
└── src/
    ├── main/
    │   ├── java/com/demandasAPI/demandasAPI/
    │   │   ├── DemandasApiApplication.java   # Application entry point
    │   │   ├── Config/
    │   │   │   └── CorsConfig.java           # CORS configuration
    │   │   ├── Controller/                   # REST controllers
    │   │   ├── Service/                      # Business logic
    │   │   ├── Model/
    │   │   │   └── DTO/                      # Data Transfer Objects
    │   │   └── Repository/                   # MongoDB repositories
    │   └── resources/
    │       └── application.properties        # Runtime configuration
    └── test/
        └── java/com/demandasAPI/demandasAPI/
            └── DemandasApiApplicationTests.java
```
