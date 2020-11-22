CREATE database DBXPTO;

USE DBXPTO;

CREATE TABLE Cliente
(
	idCliente int NOT NULL auto_increment,
    nome varchar(100),
    cpf varchar(20),
    rg varchar(20),
    email varchar(50),
    dataNascimento date,
    PRIMARY KEY (idCliente),
    
);

CREATE TABLE Endereco
(
	idEndereco int NOT NULL auto_increment,
    idCliente int NOT NULL,
    rua varchar(100),
    cidade varchar(20),
    numero long,
    uf varchar(2),
    constraint pk_idEndereco PRIMARY KEY (idEndereco)
    foreign key (idCliente) references Cliente (idCliente)
);


select * from cliente;
select * from endereco;


DROP TABLE Cliente;
DROP TABLE ENDERECO;