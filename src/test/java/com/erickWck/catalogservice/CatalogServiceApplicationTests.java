package com.erickWck.catalogservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CatalogServiceApplicationTests {

    @Test
    void name() {
    }

    //    @Autowired
//    private WebTestClient webTestClient;
//
//    @Test
//    void whenPostRequestThenProductCreated() {
//        var orderId = 1L;
//        var productCreate = Product.ofTest(orderId, "Iphone X", "Plus",
//                "Apple", BigDecimal.valueOf(3800.99), "Qualidade de Software");
//
//        Product expectedProduct = webTestClient.post()
//                .uri("/products")
//                .bodyValue(productCreate)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody(Product.class).value(p -> {
//                    assertThat(p).isNotNull();
//                    assertThat(p.idprod());
//                })
//                .returnResult().getResponseBody();
//
//    }


}
