package com.erickWck.catalogservice.web.exception;

public class ProductAlreadyExist extends RuntimeException {

    public ProductAlreadyExist(String name) {
        super("Produto com o nome: " + name + ", já existe.");
    }

}
