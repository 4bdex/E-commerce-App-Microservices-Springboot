package ma.enset.billing_service.web;

import lombok.AllArgsConstructor;
import ma.enset.billing_service.entities.Bill;
import ma.enset.billing_service.feign.CustomerRestClient;
import ma.enset.billing_service.feign.ProductRestClient;
import ma.enset.billing_service.repositories.BillRepository;
import ma.enset.billing_service.repositories.ProductItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

@RestController
@AllArgsConstructor
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).orElseThrow();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });

        return bill;
    }
}
