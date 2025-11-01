package ma.enset.billing_service.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.billing_service.model.Customer;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private LocalDate billingDate;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    private Long customerId;
    @Transient
    private Customer customer;
}
