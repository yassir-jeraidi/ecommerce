package com.enset.billingservice.repos;

import com.enset.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "bills")
public interface BillRepository extends JpaRepository<Bill, String> {
    List<Bill> getBillById(String id);
}