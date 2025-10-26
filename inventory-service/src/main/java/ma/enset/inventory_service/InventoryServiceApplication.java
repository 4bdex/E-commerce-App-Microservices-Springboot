package ma.enset.inventory_service;

import ma.enset.inventory_service.entities.Product;
import ma.enset.inventory_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            repository.save(Product.builder().name("Inventory 1").price(22f).quantity(10).build());
            repository.save(Product.builder().name("Inventory 2").price(22f).quantity(10).build());
            repository.save(Product.builder().name("Inventory 3").price(22f).quantity(10).build());
            repository.save(Product.builder().name("Inventory 4").price(22f).quantity(10).build());
            repository.save(Product.builder().name("Inventory 5").price(22f).quantity(10).build());
            repository.save(Product.builder().name("Inventory 6").price(22f).quantity(10).build());
        };
    }
}
