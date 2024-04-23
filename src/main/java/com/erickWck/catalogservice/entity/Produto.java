package com.erickWck.catalogservice.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;


@Builder(toBuilder = true)
@Entity(name = "produtos")
public record Produto(

        @NotBlank(message = "Insira o nome do produto")
        @Range(min = 5, max = 150, message = "O nome deve estar entre {min} e {max} caracterer.")
        String name,

        @NotBlank(message = "Insira o modelo do produto")
        @Range(min = 5, max = 100, message = "O modelo deve estar entre {min} e {max} caracterer.")
        String modelo,

        @NotNull(message = "Insira o preço do produto")
        BigDecimal preco,

        @NotBlank(message = "Insira a marca do produto")
        @Range(min = 5, max = 100, message = "A marca deve estar entre {min} e {max} caracterer.")
        String marca,

        @NotBlank(message = "Insira a descricao do produto")
        @Range(min = 5, max = 150, message = "A descrição deve estar entre {min} e {max} caracterer.")
        String descricao
) {

    public Produto {
    }
}

