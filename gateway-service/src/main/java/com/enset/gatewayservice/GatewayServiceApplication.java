package com.enset.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

//    @Bean
//    RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(r -> r.path("/api/customers/**")
//                        .uri("http://localhost:8081"))
//                .route(r -> r.path("/api/products/**")
//                        .uri("http://localhost:8082"))
//                .build();
//    }

//    @Bean
//    RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(r -> r.path("/api/customers/**")
//                        .uri("lb://CUSTOMER-SERVICE"))
//                .route(r -> r.path("/api/products/**")
//                        .uri("lb://INVENTORY-SERVICE"))
//                .build();
//    }

    @Bean
    DiscoveryClientRouteDefinitionLocator locator(
            ReactiveDiscoveryClient discoveryClient,
            DiscoveryLocatorProperties properties
    ){
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient , properties);
    }

}
