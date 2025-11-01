package ma.enset.billing_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Float price;
    private Integer quantity;
}
