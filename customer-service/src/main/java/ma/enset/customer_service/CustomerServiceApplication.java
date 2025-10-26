package ma.enset.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.enset.customer_service.entities.Customer;
import ma.enset.customer_service.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository ){
		return args -> {
			customerRepository.save(Customer.builder()
							.name("A").email("A@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("B").email("B@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("C").email("C@gmail.com")
					.build());
			customerRepository.findAll().forEach(c->{
				System.out.println("======================");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("=======================");
			});
		};
	}

}
