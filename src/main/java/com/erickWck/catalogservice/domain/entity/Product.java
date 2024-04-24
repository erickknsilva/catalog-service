package com.erickWck.catalogservice.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.math.BigDecimal;
import java.time.Instant;

public record Product(

        @Id
        Long idprod,

        @NotBlank(message = "Insira o nome do produto")
        @Size(min = 3, max = 150, message = "O nome deve estar entre {min} e {max} caracterer.")
        String name,

        @NotBlank(message = "Insira o modelo do produto")
        @Size(min = 2, max = 100, message = "O modelo deve estar entre {min} e {max} caracterer.")
        String modelo,

        @NotBlank(message = "Insira a marca do produto")
        @Size(min = 2, max = 100, message = "A marca deve estar entre {min} e {max} caracterer.")
        String marca,

        @NotNull(message = "Insira o preço do produto")
        BigDecimal preco,


        @NotBlank(message = "Insira a descricao do produto")
        @Size(min = 5, max = 150, message = "A descrição deve estar entre {min} e {max} caracterer.")
        String descricao,

        @CreatedDate
        Instant created_date,

        @LastModifiedDate
        Instant last_modified_date,

        @Version
        int version
) {


    public static Product of(String name, String modelo,
                             String marca, BigDecimal preco, String descricao) {

        return new Product(null, name, modelo, marca, preco, descricao,
                null, null, 0);
    }


}

