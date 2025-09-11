CREATE TABLE Pessoa (
       id  integer,
        cpf varchar(255),
        dataDeNascimento datetime,
        email varchar(255),
        idade integer,
        nome varchar(255),
        primary key (id)
    )

CREATE TABLE Produto (
       id  integer,
        nome varchar(255),
        preco double precision not null,
        quantidade integer,
        status boolean not null,
        primary key (id)
    )