package com.erickWck.catalogservice.mapper;

import com.erickWck.catalogservice.domain.entity.Product;

import java.math.BigDecimal;

public record ProductMapper(

        Long id,
        String name,
        String modelo,
        String marca,
        BigDecimal preco,
        String descricao

) {

    public static ProductMapper fromEntityToDto(Product product) {
        return new ProductMapper(product.idprod(), product.name(), product.modelo(),
                product.marca(), product.preco(), product.descricao());
    }


}
