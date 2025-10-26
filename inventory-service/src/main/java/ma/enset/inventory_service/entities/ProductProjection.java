package ma.enset.inventory_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Product.class)
public interface ProductProjection {
}
