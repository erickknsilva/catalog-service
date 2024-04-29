package com.erickWck.catalogservice.web;

import com.erickWck.catalogservice.domain.repositorys.ProductRepository;
import com.erickWck.catalogservice.mapper.ProductResponse;
import com.erickWck.catalogservice.web.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ProductServiceQuery {

    private final ProductRepository productRepository;

    @Cacheable(value = "productService", key = "#id")
    public ProductResponse viewDetailsOrders(final Long id) {
        return productRepository.findByIdprod(id)
                .map(product -> ProductResponse.fromEntityToDto(product))
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


    public List<ProductResponse> viewListAllDetailsProduct(final List<Long> id) {

        List<ProductResponse> collectListOrders = getCollect(id);

        return collectListOrders;
    }

    private List<ProductResponse> getCollect(List<Long> id) {

        return StreamSupport
                .stream(productRepository.findAllById(id).spliterator(),
                        false)
                .map(product -> ProductResponse.fromEntityToDto(product))
                .collect(Collectors.toList());
    }

}