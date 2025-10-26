package com.enset.inventoryservice;

import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.repos.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Stream.of("Iphone", "Samsung", "Huawei").forEach(name -> {
                Product product = Product.builder()
                        .name(name)
                        .price(100 + Math.random() * 900)
                        .quantity(1 + (int) (Math.random() * 100))
                        .build();
                productRepository.save(product);
            });
        };
    }
}
