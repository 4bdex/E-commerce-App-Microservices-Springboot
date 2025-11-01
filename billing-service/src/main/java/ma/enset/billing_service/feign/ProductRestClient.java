package ma.enset.billing_service.feign;

import ma.enset.billing_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    public PagedModel<Product> getAllProducts();
}
