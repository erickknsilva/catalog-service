package com.erickWck.catalogservice.demo;

import com.erickWck.catalogservice.domain.entity.Product;
import com.erickWck.catalogservice.domain.repositorys.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("testdata")
public class DataLoader {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {

        var productCreate1 = Product.ofTest(1L, "Samsung S24",
                "Plus", "Samsung", new BigDecimal(5500.99),
                "Qualidade de Software");

        var productCreate2 = Product.ofTest(2L, "Samsung S3",
                "Plus", "Samsung",
                new BigDecimal(4500.00), "Qualidade de Software");

        productRepository.save(productCreate1);
        productRepository.save(productCreate2);
    }

}
