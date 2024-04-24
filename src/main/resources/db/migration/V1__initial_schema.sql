CREATE TABLE product (
    idprod BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(150) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_date timestamp NOT NULL,
    version integer NOT NULL
);
