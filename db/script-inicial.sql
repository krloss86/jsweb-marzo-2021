CREATE TABLE productos (
	id SERIAL primary key NOT NULL,
	titulo VARCHAR(50) NOT NULL,
	precio FLOAT NOT NULL,
	codigo VARCHAR(6) NOT NULL,
	id_tipo_producto INT NOT NULL
);
alter table PRODUCTOS add constraint codigo_unique unique (CODIGO);

CREATE TABLE users (
	id SERIAL primary key NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
);
alter table users add constraint username_unique unique (username);
INSERT INTO users (username, password) values('eduit','eduit');

-- Volcando estructura de base de datos para digitalers
--CREATE DATABASE IF NOT EXISTS bootcamp1;
--USE bootcamp1;

CREATE TABLE IF NOT EXISTS newsletter (
  id SERIAL PRIMARY KEY NOT NULL,
  email varchar(100) NOT NULL,
  fecha_alta date NOT NULL
);

-- Volcando estructura para tabla digitalers.categorias
CREATE TABLE IF NOT EXISTS categorias (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  codigo varchar(10) NOT NULL,
  habilitada int NOT NULL
);

-- Volcando estructura para tabla digitalers.marcas
CREATE TABLE IF NOT EXISTS marcas (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  codigo varchar(10) NOT NULL,
  habilitada int NOT NULL
) ;

-- Volcando estructura para tabla digitalers.cupones
CREATE TABLE IF NOT EXISTS cupones (
  id SERIAL PRIMARY KEY NOT NULL,
  nombre varchar(100) NOT NULL,
  codigo varchar(10) NOT NULL,
  fecha_vigencia_desde date NOT NULL,
  fecha_vigencia_hasta date DEFAULT NULL,
  descuento float DEFAULT 0
) ;

-- Volcando estructura para tabla digitalers.articulos
CREATE TABLE IF NOT EXISTS articulos (
  id SERIAL PRIMARY KEY NOT NULL,
  titulo varchar(100) NOT NULL,
  codigo varchar(10) NOT NULL,
  fecha_creacion date NOT NULL,
  precio float NOT NULL,
  stock int NOT NULL,
  marcas_id int NOT NULL,
  categorias_id int NOT NULL  
) ;

CREATE TABLE IF NOT EXISTS paises (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(100) NOT NULL,
  descripcion_corta varchar(6) NOT NULL,
  habilitada int NOT NULL
);

CREATE TABLE IF NOT EXISTS socios (
  id SERIAL PRIMARY KEY NOT NULL,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  email varchar(100) DEFAULT NULL,
  fecha_alta date NOT NULL
) ;

CREATE TABLE IF NOT EXISTS estados_ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  descripcion_corta varchar(45) DEFAULT NULL,
  estado_final int NOT NULL
) ;

CREATE TABLE IF NOT EXISTS medios_pagos (
  id SERIAL PRIMARY KEY NOT NULL,
  descripcion varchar(100) NOT NULL,
  descripcion_corta varchar(10) NOT NULL,
  codigo varchar(5) NOT NULL,
  habilitada int NOT NULL
) ;

CREATE TABLE IF NOT EXISTS ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  fecha_creacion date DEFAULT NULL,
  socios_id int DEFAULT NULL,
  estados_ordenes_id int DEFAULT NULL,
  monto_total float DEFAULT NULL,
  cupones_id int DEFAULT NULL  
) ;

CREATE TABLE IF NOT EXISTS direcciones_ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  ordenes_id int NOT NULL,
  paises_id int NOT NULL,
  direccion_envio varchar(500) NOT NULL
) ;

CREATE TABLE IF NOT EXISTS ordenes_items (
  id SERIAL PRIMARY KEY NOT NULL,
  ordenes_id int NOT NULL,
  numero_item int NOT NULL,
  cantidad int NOT NULL,
  articulos_id int NOT NULL,
  precio_unitario float NOT NULL
) ;

CREATE TABLE IF NOT EXISTS pagos_ordenes (
  id SERIAL PRIMARY KEY NOT NULL,
  ordenes_id int NOT NULL,
  medios_pagos_id int NOT NULL,
  fecha_pago date NOT NULL,
  monto float NOT NULL
) ;

-- La exportación de datos fue deseleccionada.
--ARTICULOS
ALTER TABLE ARTICULOS ADD CONSTRAINT FK_articulos_categorias FOREIGN KEY (CATEGORIAS_ID) REFERENCES CATEGORIAS(ID);
ALTER TABLE ARTICULOS ADD CONSTRAINT FK_articulos_marcas FOREIGN KEY (MARCAS_ID) REFERENCES MARCAS(ID);
ALTER TABLE ARTICULOS ADD CONSTRAINT UN_articulos_codigo unique (CODIGO);

--constraint de tabla ordenes
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_estados_ordenes FOREIGN KEY (ESTADOS_ORDENES_ID) REFERENCES ESTADOS_ORDENES(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_socios FOREIGN KEY (SOCIOS_ID) REFERENCES SOCIOS(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_cupones FOREIGN KEY (CUPONES_ID) REFERENCES CUPONES(ID);

ALTER TABLE ORDENES_ITEMS ADD CONSTRAINT FK_items_ordenes_ordenes FOREIGN KEY (ordenes_id) REFERENCES ORDENES(ID);

ALTER TABLE ORDENES_ITEMS ADD CONSTRAINT FK_items_ordenes_articulos FOREIGN KEY (articulos_id) REFERENCES ARTICULOS(ID);

ALTER TABLE PAGOS_ORDENES ADD CONSTRAINT FK_pagos_ordenes_ordenes FOREIGN KEY (ordenes_id) REFERENCES ORDENES(ID);
ALTER TABLE PAGOS_ORDENES ADD CONSTRAINT FK_pagos_ordenes_medios_pagos FOREIGN KEY (medios_pagos_id) REFERENCES MEDIOS_PAGOS(ID);

ALTER TABLE DIRECCIONES_ORDENES ADD CONSTRAINT FK_direcciones_ordenes_ordenes FOREIGN KEY (ordenes_id) REFERENCES ORDENES(ID);
ALTER TABLE DIRECCIONES_ORDENES ADD CONSTRAINT FK_direcciones_ordenes_paises FOREIGN KEY (paises_id) REFERENCES PAISES(ID);

ALTER TABLE MARCAS ADD CONSTRAINT UN_marcas_codigo unique (CODIGO);
ALTER TABLE CATEGORIAS ADD CONSTRAINT UN_categorias_codigo unique (CODIGO);

ALTER TABLE CUPONES ADD CONSTRAINT CHECK_DESCUENTO CHECK(DESCUENTO >= 0 AND DESCUENTO <=100);

--datos iniciales de prueba
insert into CATEGORIAS (descripcion,codigo,habilitada) values('categoria 1', 'cat000',1);
insert into MARCAS (descripcion, codigo,habilitada) values('marca 1', 'cod000',1);

--datos socios
insert into socios(nombre, apellido,email,fecha_alta) values('carlos','lopez','email@email.com',CURRENT_DATE);

--estados ordenes
insert into estados_ordenes (descripcion,descripcion_corta,estado_final) values('ESTADO CREADA','INICIAL', 0); 
insert into estados_ordenes (descripcion,descripcion_corta,estado_final) values('ESTADO FACTURADA','FACTURADA', 1);

--medios pagos
insert into medios_pagos (descripcion,descripcion_corta,codigo,habilitada) values('EFECTIVO CONTRAREEMBOLSO','EFE_REE','001',1);

--paises
insert into paises (descripcion, descripcion_corta,habilitada) values('ARGENTINA','ARG',1);

--cupones
insert into cupones (nombre,codigo,fecha_vigencia_desde,fecha_vigencia_hasta, descuento) values('BIENVENIDA','001',CURRENT_DATE, date_add(CURRENT_DATE, interval 10 day),50);
--incrementar una fecha 10 dias en mysql
--select date_add(CURRENT_DATE, interval 10 day)

