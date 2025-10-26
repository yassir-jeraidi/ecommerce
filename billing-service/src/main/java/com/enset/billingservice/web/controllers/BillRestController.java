package com.enset.billingservice.web.controllers;

import com.enset.billingservice.entities.Bill;
import com.enset.billingservice.feign.CustomerRestClient;
import com.enset.billingservice.feign.ProductRestClient;
import com.enset.billingservice.repos.BillRepository;
import com.enset.billingservice.repos.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BillRestController {
    private final BillRepository billRepository;
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;

    @GetMapping("/api/bills/detail/{id}")
    public Bill getBill(@PathVariable String id) {
        Bill bill = billRepository.getBillById(id).getFirst();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductID()));
        });
        return bill;
    }
}
