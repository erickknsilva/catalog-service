package com.erickWck.catalogservice.mapper;

import com.erickWck.catalogservice.domain.entity.Product;

import java.math.BigDecimal;

public record ProductResponse(

        Long id,
        String name,
        String modelo,
        String marca,
        BigDecimal preco,
        String descricao

) {

    public static ProductResponse fromEntityToDto(Product product) {
        return new ProductResponse(product.idprod(), product.name(), product.modelo(),
                product.marca(), product.preco(), product.descricao());
    }


}
