package ma.enset.billing_service.repositories;

import ma.enset.billing_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
