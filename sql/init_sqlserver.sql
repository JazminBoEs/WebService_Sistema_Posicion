-- Crear la base de datos
CREATE DATABASE Sistema_Posicion_Raspberry;
GO

USE Sistema_Posicion_Raspberry;
GO

--------------------------------------------------
-- TABLA: April_Tag
--------------------------------------------------
CREATE TABLE April_Tag (
    id_AprilTag BIGINT PRIMARY KEY,
    x FLOAT,
    y FLOAT,
    orientacion FLOAT
);
GO

--------------------------------------------------
-- TABLA: Posicion
--------------------------------------------------
CREATE TABLE Posicion (
    id_Posicion BIGINT IDENTITY(1,1) PRIMARY KEY,
    x FLOAT,
    y FLOAT,
    orientacion FLOAT,
    fecha DATETIME
);
GO

--------------------------------------------------
-- TABLA: Relacion
-- (Relaciona una Posicion con N AprilTags)
--------------------------------------------------
CREATE TABLE Relacion (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    id_Posicion BIGINT,
    id_AprilTag BIGINT,
    FOREIGN KEY (id_Posicion) REFERENCES Posicion(id_Posicion),
    FOREIGN KEY (id_AprilTag) REFERENCES April_Tag(id_AprilTag)
);
GO

--------------------------------------------------
-- INSERT APRIL TAGS (Basados en tu JSON layout)
--------------------------------------------------
INSERT INTO April_Tag (id_AprilTag, x, y, orientacion) VALUES
(0, 0.0,   1.11,  0),
(1, 1.230, 0.0,   90),
(2, 0.0,   2.197, 0),
(3, 3.60,  1.038, 180),
(4, 2.634, 0.0,   90),
(5, 2.51,  2.8,   270),
(6, 1.35,  2.8,   270),
(7, 3.60,  1.985, 180);
GO
