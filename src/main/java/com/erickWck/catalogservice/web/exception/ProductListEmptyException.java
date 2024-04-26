package com.erickWck.catalogservice.web.exception;

public class ProductListEmptyException extends RuntimeException {

    public ProductListEmptyException() {
        super("A lista não pode estar vazia.");
    }

}
