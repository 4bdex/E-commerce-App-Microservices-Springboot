package ma.enset.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

// ?projection=all
@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
    String getName();
    String getEmail();
}