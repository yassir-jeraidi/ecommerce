package com.enset.billingservice.repos;

import com.enset.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productItems")
public interface ProductItemRepository extends JpaRepository<ProductItem, String> {
}