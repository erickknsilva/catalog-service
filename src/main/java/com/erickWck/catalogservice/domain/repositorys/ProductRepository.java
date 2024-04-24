package com.erickWck.catalogservice.domain.repositorys;

import com.erickWck.catalogservice.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    boolean existsByName(String name);

    boolean existsByIdprod(Long id);

    Optional<Product> findByIdprod(Long id);

}
