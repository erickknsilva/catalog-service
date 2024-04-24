package com.erickWck.catalogservice.web;

import com.erickWck.catalogservice.domain.entity.Product;
import com.erickWck.catalogservice.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductMapper postSave(@Valid @RequestBody Product product) {
        return productService.addCatalog(product);
    }


    @GetMapping("/find/{id}")
    public ProductMapper findById(@PathVariable @Valid Long id) {
        return productService.viewDetailsProduct(id);
    }

    @GetMapping("/edit/{id}")
    public ProductMapper editProductById(@PathVariable @Valid Long id, @RequestBody @Valid Product product) {
        return productService.editDetailsProduct(id, product);
    }

    @GetMapping
    public List<ProductMapper> findAll() {
        return productService.listAllProduct();
    }

    @DeleteMapping("/delete/{id}")
    public void removeProduct(@PathVariable("id") Long id) {
        productService.remove(id);
    }

}
