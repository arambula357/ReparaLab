-- Esquema reconstruido para demostraci?n local. No contiene datos del negocio.
CREATE DATABASE IF NOT EXISTS reparalab_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE reparalab_demo;

CREATE TABLE IF NOT EXISTS preferencias (
  nombre VARCHAR(40) PRIMARY KEY,
  empresa VARCHAR(120) NOT NULL,
  propietario VARCHAR(120) NOT NULL,
  rfc VARCHAR(30) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  telefono VARCHAR(30) NOT NULL,
  condiciones TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS usuarios (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nombre_usuario VARCHAR(120) NOT NULL,
  email VARCHAR(180) NOT NULL,
  telefono VARCHAR(30) NOT NULL,
  username VARCHAR(80) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  tipo_nivel VARCHAR(30) NOT NULL,
  estatus VARCHAR(30) NOT NULL,
  registrado_por VARCHAR(80) NOT NULL
);
CREATE TABLE IF NOT EXISTS clientes (
  id_cliente INT AUTO_INCREMENT PRIMARY KEY,
  nombre_cliente VARCHAR(150) NOT NULL,
  tel_cliente VARCHAR(30) NOT NULL,
  ultima_modificacion VARCHAR(80) NOT NULL
);
CREATE TABLE IF NOT EXISTS equipos (
  id_equipo INT AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT NOT NULL,
  tipo_equipo VARCHAR(80) NOT NULL,
  marca VARCHAR(80) NOT NULL,
  modelo VARCHAR(80) NOT NULL,
  num_serie VARCHAR(120) NOT NULL,
  dia_ingreso VARCHAR(2) NOT NULL,
  mes_ingreso VARCHAR(2) NOT NULL,
  annio_ingreso VARCHAR(4) NOT NULL,
  hora_ingreso VARCHAR(16) NOT NULL,
  observaciones TEXT NOT NULL,
  estatus VARCHAR(40) NOT NULL,
  ultima_modificacion VARCHAR(80) NOT NULL,
  comentarios_tecnicos TEXT NOT NULL,
  revision_tecnica_de VARCHAR(80) NOT NULL
);
CREATE TABLE IF NOT EXISTS articulos (
  id_articulo INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(150) NOT NULL,
  codigo VARCHAR(60) NOT NULL UNIQUE,
  cantidad INT NULL,
  precio DECIMAL(12,2) NOT NULL,
  tipo_articulo VARCHAR(30) NOT NULL,
  ultima_modificacion VARCHAR(80) NOT NULL
);
CREATE TABLE IF NOT EXISTS ventas (
  id_venta INT AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT NOT NULL,
  id_equipo INT NOT NULL,
  articulos TEXT NOT NULL,
  tipo_venta VARCHAR(30) NOT NULL,
  total DECIMAL(12,2) NOT NULL,
  fecha_venta DATE NOT NULL,
  vendedor VARCHAR(120) NOT NULL,
  estatus VARCHAR(30) NOT NULL,
  cancelada_por VARCHAR(120) NOT NULL
);
CREATE TABLE IF NOT EXISTS sumatoria (
  id_sumatoria INT AUTO_INCREMENT PRIMARY KEY,
  id_venta INT NOT NULL,
  cantidad INT NOT NULL,
  codigo VARCHAR(60) NOT NULL,
  nombre VARCHAR(150) NOT NULL,
  precio DECIMAL(12,2) NOT NULL,
  fecha_venta DATE NOT NULL,
  tipo_venta VARCHAR(30) NOT NULL,
  estatus VARCHAR(30) NOT NULL
);
CREATE TABLE IF NOT EXISTS salidas (
  id_salida INT AUTO_INCREMENT PRIMARY KEY,
  cantidad_salida DECIMAL(12,2) NOT NULL,
  concepto_salida VARCHAR(180) NOT NULL,
  fecha_salida DATE NOT NULL,
  hora_salida VARCHAR(16) NOT NULL,
  registrada_por VARCHAR(120) NOT NULL
);
CREATE TABLE IF NOT EXISTS inicioturno (
  id_inicioturno INT AUTO_INCREMENT PRIMARY KEY,
  cantidad DECIMAL(12,2) NOT NULL,
  fecha VARCHAR(12) NOT NULL,
  usuario VARCHAR(80) NOT NULL
);

INSERT INTO preferencias (nombre,empresa,propietario,rfc,direccion,telefono,condiciones)
VALUES ('InfoEmpresa','ReparaLab Demo','Equipo Demo','','Direcci?n de ejemplo','','Diagn?stico sujeto a revisi?n.')
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);
INSERT INTO usuarios (nombre_usuario,email,telefono,username,password,tipo_nivel,estatus,registrado_por)
VALUES
('Administrador Demo','','','admin','$pbkdf2-sha256$310000$SqYRHc5EswQXt/rHoEqeBg==$0rEMNUK801glj5XfxVB3q4yEFHfmcann7UYsgQvnyLU=','Administrador','Activo','demo'),
('Capturista Demo','','','capturista','$pbkdf2-sha256$310000$UpygDus9unLqZT5wwU/d5A==$b0jr0yA4eomBq/9hu6h8tIqhgE0wlwlwT5t+G7Aou9E=','Capturista','Activo','demo'),
('T?cnico Demo','','','tecnico','$pbkdf2-sha256$310000$v2x9nyV/OQPfmtmqisFUVg==$KhN+Xxv28SOmfwQDhUrh2hLs3cKs4a0x9dLwdP2Veq4=','Tecnico','Activo','demo')
ON DUPLICATE KEY UPDATE username=VALUES(username);
