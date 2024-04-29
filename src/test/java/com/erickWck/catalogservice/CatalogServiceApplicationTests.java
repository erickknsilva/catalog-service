package com.erickWck.catalogservice;

import com.erickWck.catalogservice.domain.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenProductCreated() {
        var orderId = 1L;
        var productCreate = Product.ofTest(orderId, "Iphone X", "Plus",
                "Apple", BigDecimal.valueOf(3800.99), "Qualidade de Software");

        Product expectedProduct = webTestClient.post()
                .uri("/products")
                .bodyValue(productCreate)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Product.class).value(p -> {
                    assertThat(p).isNotNull();
                    assertThat(p.idprod());
                })
                .returnResult().getResponseBody();

    }



}
