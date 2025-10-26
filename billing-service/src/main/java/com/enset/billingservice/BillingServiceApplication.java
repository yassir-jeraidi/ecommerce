package com.enset.billingservice;

import com.enset.billingservice.entities.Bill;
import com.enset.billingservice.entities.Customer;
import com.enset.billingservice.entities.Product;
import com.enset.billingservice.entities.ProductItem;
import com.enset.billingservice.feign.CustomerRestClient;
import com.enset.billingservice.feign.ProductRestClient;
import com.enset.billingservice.repos.BillRepository;
import com.enset.billingservice.repos.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductRestClient productRestClient
    ) {

        return args -> {
            Collection<Product> products = productRestClient.getAllProducts().getContent();
            Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();


            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customer(customer)
                        .customerID(customer.getId())
                        .build();
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .quantity((int) (10 + 50 * Math.random()))
                            .price(product.getPrice() - product.getPrice() * 0.2)
                            .productID(product.getId())
                            .bill(bill)
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
