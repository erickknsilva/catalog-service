package com.erickWck.catalogservice.web;

import com.erickWck.catalogservice.domain.entity.Product;
import com.erickWck.catalogservice.mapper.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;
    private final ProductQuery productQuery;

    public ProductController(ProductService productService, ProductQuery productQuery) {
        this.productService = productService;
        this.productQuery = productQuery;
    }

    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getSubmitOrders(@Valid @RequestBody OrdersRequest request) {
        return productQuery.viewDetailsOrders(request.idProducts());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProductResponse postSave(@Valid @RequestBody Product product) {
        return productService.addCatalog(product);
    }


    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse findById(@PathVariable @Valid Long id) {
        return productQuery.viewDetailsProduct(id);
    }

    @GetMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse editProductById(@PathVariable @Valid Long id, @RequestBody @Valid Product product) {
        return productService.editDetailsProduct(id, product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> findAll() {
        return productService.listAllProduct();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable("id") Long id) {
        productService.remove(id);
    }

}
