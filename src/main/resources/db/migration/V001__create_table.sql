create table client (
	id 			BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome		varchar(255)		not null,
	cpf			varchar(255)		not null,
	cep 		varchar(255)		not null,
	cidade  	varchar(255)		not null,
	bairro		varchar(255)		not null,
	logradouro 	varchar(255)		not null
);