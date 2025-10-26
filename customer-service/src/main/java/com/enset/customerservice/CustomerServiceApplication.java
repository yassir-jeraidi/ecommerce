package com.enset.customerservice;

import com.enset.customerservice.entities.Customer;
import com.enset.customerservice.repos.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Yassir" , "Ahmed" , "Rim").forEach(name -> {
               Customer customer = Customer.builder()
                       .name(name)
                       .email(name + "@gmail.com")
                       .phoneNumber("06 00 00 00 00")
                       .build();
               customerRepository.save(customer);
            });
        };
    }
}
