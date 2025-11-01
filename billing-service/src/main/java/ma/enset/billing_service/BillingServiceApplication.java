package ma.enset.billing_service;

import ma.enset.billing_service.entities.Bill;
import ma.enset.billing_service.entities.ProductItem;
import ma.enset.billing_service.feign.CustomerRestClient;
import ma.enset.billing_service.feign.ProductRestClient;
import ma.enset.billing_service.model.Customer;
import ma.enset.billing_service.model.Product;
import ma.enset.billing_service.repositories.BillRepository;
import ma.enset.billing_service.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductRestClient productRestClient) {
        return args -> {
            Customer customer = customerRestClient.getCustomerById(1L);
            System.out.println("*******************************");
            System.out.println(customer);
            System.out.println("*******************************");

            Bill bill = Bill.builder()
                    .billingDate(java.time.LocalDate.now())
                    .customerId(customer.getId())
                    .customer(customer)
                    .build();
            Bill savedBill = billRepository.save(bill);

             Collection<Product> products = productRestClient.getAllProducts().getContent();
            products.forEach(product -> {
                ProductItem productItem = ProductItem.builder()
                        .product(product)
                        .productId(product.getId())
                        .bill(savedBill)
                        .price(product.getPrice())
                        .quantity(5 + (int) (Math.random() * 95))
                        .build();
                productItemRepository.save(productItem);
            });
        };
    }
}
