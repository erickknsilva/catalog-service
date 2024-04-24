package com.erickWck.catalogservice.web;

import com.erickWck.catalogservice.web.exception.ProductAlreadyExist;
import com.erickWck.catalogservice.web.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProdutctControlleAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    String productNotFoundHandler(ProductNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ProductAlreadyExist.class)
    String productAlreadExistsHandler(ProductAlreadyExist ex) {
        return ex.getMessage();
    }


}