package com.erickWck.catalogservice.web;

import com.erickWck.catalogservice.domain.entity.Product;
import com.erickWck.catalogservice.domain.repositorys.ProductRepository;
import com.erickWck.catalogservice.mapper.ProductMapper;
import com.erickWck.catalogservice.web.exception.ProductAlreadyExist;
import com.erickWck.catalogservice.web.exception.ProductNotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
@EqualsAndHashCode
public class ProductService {

    private final ProductRepository productRepository;

    public ProductMapper addCatalog(final Product product) {

        if (productRepository.existsByName(product.name())) {
            throw new ProductAlreadyExist(product.name());
        }
        return ProductMapper.fromEntityToDto(productRepository.save(product));
    }

    public ProductMapper viewDetailsProduct(Long id) {
        return productRepository.findByIdprod(id)
                .map(product -> ProductMapper.fromEntityToDto(product))
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public ProductMapper editDetailsProduct(Long id, Product product) {
        return productRepository.findById(id)
                .map(existProd -> {
                    var productUpdate = new Product(existProd.idprod(),
                            product.name(), product.modelo(), product.marca(),
                            product.preco(), product.descricao(),
                            existProd.created_date(),
                            existProd.last_modified_date(),
                            existProd.version());
                    return ProductMapper.fromEntityToDto(productRepository.save(productUpdate));
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void remove(Long id) {
        if (!productRepository.existsByIdprod(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }

    public List<ProductMapper> listAllProduct() {
        return StreamSupport.
                stream(productRepository.findAll().spliterator(), false)
                .map(ProductMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }


}