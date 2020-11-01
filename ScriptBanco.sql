CREATE database DBXPTO;

USE DBXPTO;

CREATE TABLE Cliente
(
	id int NOT NULL auto_increment,
    nome varchar(100),
    cpf varchar(100),
    idade int,
    constraint pk_idCliente PRIMARY KEY (id)
);