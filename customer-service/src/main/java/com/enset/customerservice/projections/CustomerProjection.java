package com.enset.customerservice.projections;

import com.enset.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Customer.class)
public interface CustomerProjection {
    Long getId();
    String getName();
    String getEmail();
//    String getPhoneNumber();
}
