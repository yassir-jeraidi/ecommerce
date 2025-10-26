package com.enset.customerservice.repos;

import com.enset.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}