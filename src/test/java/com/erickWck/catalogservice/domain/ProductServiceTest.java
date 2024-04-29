//package com.erickWck.catalogservice.domain;
//
//import com.erickWck.catalogservice.domain.entity.Product;
//import com.erickWck.catalogservice.domain.repositorys.ProductRepository;
//import com.erickWck.catalogservice.web.ProductService;
//import com.erickWck.catalogservice.web.exception.ProductAlreadyExist;
//import org.assertj.core.api.AssertionsForClassTypes;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductService productService;
//
//    @Test
//    void whenProductToCreateAlreadyExistsThenThrows() {
//        var productId = 1L;
//        var productCreate = Product.ofTest(productId, "Iphone 14", "Plus",
//                "Apple", BigDecimal.valueOf(5400.99), "Qualidade de Software");
//
//        when(productRepository.existsByIdprod(productId)).thenReturn(true);
//        AssertionsForClassTypes.assertThatThrownBy(() > productService.addCatalog(productCreate))
//                .isInstanceOf(ProductAlreadyExist.class)
//                .hasMessage("Produto com identifacador" + productId + ", já existe");
//
//    }
//
//
//}
