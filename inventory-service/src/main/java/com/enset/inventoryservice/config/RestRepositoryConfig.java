package com.enset.inventoryservice.config;


import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.projections.ProductProjection;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Product.class);
        config.getProjectionConfiguration().addProjection(ProductProjection.class);
    }

}
