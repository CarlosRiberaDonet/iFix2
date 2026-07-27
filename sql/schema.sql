-- CREAR LA BASE DE DATOS
DROP DATABASE IF EXISTS reparaciones;
CREATE DATABASE reparaciones;
USE reparaciones;

-- TABLA CLIENTE
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL,
	dni VARCHAR(9) NOT NULL UNIQUE,
    telefono VARCHAR(20) NOT NULL UNIQUE,
    direccion VARCHAR(255)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE cliente ADD COLUMN dni VARCHAR(9) NOT NULL UNIQUE;

-- TABLA MARCA
CREATE TABLE marca (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- TABLA MODELO
CREATE TABLE modelo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    id_marca BIGINT,
    FOREIGN KEY (id_marca) REFERENCES marca(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- TABLA DISPOSITIVO
CREATE TABLE dispositivo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imei VARCHAR(15) NOT NULL UNIQUE,
    codigo_desbloqueo VARCHAR(50),
    id_cliente BIGINT NOT NULL,
    id_modelo BIGINT NOT NULL,
    FOREIGN KEY fk_dispositivo_cliente (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY fk_dispositivo_modelo (id_modelo) REFERENCES modelo(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- TABLA TIPO_REPARACION (catálogo: "Cambio de pantalla", "Cambio de batería"...)
CREATE TABLE tipo_reparacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- TABLA REPARACION (la "orden de trabajo": un dispositivo, un periodo, un estado)
CREATE TABLE reparacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_dispositivo BIGINT NOT NULL,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE,
    fecha_reparacion DATE,
    garantia BOOLEAN DEFAULT FALSE,
    comentarios TEXT,
    estado VARCHAR(30),
    importe BIGINT,
    FOREIGN KEY fk_reparacion_dispositivo (id_dispositivo) REFERENCES dispositivo(id),
    INDEX idx_lookup (id_dispositivo, fecha_entrada, fecha_salida)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE reparacion ADD COLUMN fecha_reparacion DATE;

-- TABLA REPARACION_TIPO (tabla intermedia: qué trabajos y a qué precio, dentro de una reparación)
CREATE TABLE linea_reparacion (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_reparacion BIGINT NOT NULL,
    id_tipo_reparacion BIGINT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    FOREIGN KEY fk_r_reparacion (id_reparacion) REFERENCES reparacion(id) ON DELETE CASCADE,
    FOREIGN KEY fk_rt_tipo (id_tipo_reparacion) REFERENCES tipo_reparacion(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

SELECT * FROM cliente;
SELECT * FROM marca;
SELECT * FROM modelo;
SELECT * FROM tipo_reparacion;
SELECT * FROM dispositivo;
SELECT * FROM reparacion;
SELECT * FROM linea_reparacion;

TRUNCATE TABLE cliente;
TRUNCATE TABLE marca;
TRUNCATE TABLE modelo;
TRUNCATE TABLE tipo_reparacion;
TRUNCATE TABLE reparacion;
TRUNCATE TABLE dispositivo;
TRUNCATE TABLE linea_reparacion;

SET FOREIGN_KEY_CHECKS = 0; -- Desactiva la protección

SET FOREIGN_KEY_CHECKS = 1; -- Vuelve a activar la protección

INSERT INTO marca (nombre) VALUES ('APPLE');
INSERT INTO modelo (id_marca, nombre) VALUES (1, 'IPHONE 13');
