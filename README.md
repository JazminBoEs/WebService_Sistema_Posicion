# Web Service — Sistema_Posicion_Raspberry

Este proyecto implementa un servicio web en **Spring Boot** que recibe, almacena y consulta la posición de la Raspberry (o robot) usando los AprilTags detectados por PhotonVision.

## 📦 Estructura del proyecto

WebService_Sistema_Posicion/
├── pom.xml
├── README.md
├── sql/
│ └── init_sqlserver.sql
└── src/
└── main/
├── java/
│ └── com/
│ └── sistema/
│ └── raspberry/
│ ├── Application.java
│ ├── controller/
│ ├── dto/
│ ├── model/
│ └── repository/
└── resources/
└── application.properties


## 🗄 Base de datos necesaria

Nombre de la BD: **Sistema_Posicion_Raspberry**

Dentro de la carpeta `sql/` se incluye:
- `init_sqlserver.sql` → crea la BD, tablas y añade los AprilTags del cuarto.

Ejecutar en SQL Server Management Studio (SSMS).

## 🚀 Cómo correr el servicio

1. Instalar Java 17+
2. Instalar Maven
3. Configurar SQL Server con usuario:
usuario: rasp_user
contraseña: RaspPass123!!
(Editar en `application.properties` si usas otra contraseña)

4. Ejecutar:
mvn spring-boot:run
El servicio arrancará en:
http://localhost:8080

## 📡 Endpoints principales

### POST `/api/posicion`
Guarda una posición junto con los AprilTags detectados.

Ejemplo de JSON:
```json
{   
  "x": 1.5, 
  "y": 2.0, 
  "orientacion": 30, 
  "fecha": "2025-11-23T17:30:00", 
  "idAprilTag": [1, 4]
}

###GETS

# AprilTags
curl -X GET http://localhost:8080/apriltags

# Posiciones
curl -X GET http://localhost:8080/posiciones

# Última posición
curl -X GET http://localhost:8080/posiciones/ultima

# Relaciones
curl -X GET http://localhost:8080/relaciones


🧪 Pruebas rápidas con curl

Insertar una posición
curl -X POST http://localhost:8080/posiciones 
-H "Content-Type: application/json" 
-d '{"x": 1.5, 
    "y": 2.0, 
    "orientacion": 30, 
    "fecha": "2025-11-23T17:30:00", 
    "idAprilTag": [1, 4]}'



✔ Notas finales

El formato de fecha debe ser ISO (yyyy-MM-ddTHH:mm:ss)

Si la fecha no se puede interpretar, el servicio guarda la fecha actual automáticamente.

Puedes editar los AprilTags directamente en la tabla April_Tag.

