package ma.enset.billing_service.repositories;

import ma.enset.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BillRepository extends JpaRepository<Bill, Long> {
}
