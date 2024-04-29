//package com.erickWck.catalogservice.web;
//
//import com.erickWck.catalogservice.web.exception.ProductNotFoundException;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@WebMvcTest(ProductController.class)
//public class ProductControllerMvcTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @MockBean
//    private ProductServiceQuery productQuery;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//    void whenGetProductNotExistingThenShouldReturn404() throws Exception {
//        var productId = 21L;
//
//        given(productQuery.viewDetailsOrders(productId))
//                .willThrow(ProductNotFoundException.class);
//
//        mockMvc.perform(get("/products/find/" + productId))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//
//    }
//
//
//}
