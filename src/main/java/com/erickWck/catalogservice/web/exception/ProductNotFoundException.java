package com.erickWck.catalogservice.web.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Produto com ID: " + id + ", não encontrado.");
    }

}
