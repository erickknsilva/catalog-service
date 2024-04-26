package com.erickWck.catalogservice.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record OrdersRequest(
        @NotNull(message = "Insira identifacdor do produto.")
        List<Long> idProducts
) {
}
