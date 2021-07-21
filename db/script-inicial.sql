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
