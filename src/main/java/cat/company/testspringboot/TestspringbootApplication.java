package cat.company.testspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cat.company.testspringboot.dataaccess.model.Customer;
import cat.company.testspringboot.dataaccess.repositories.CustomerRepository;

@SpringBootApplication
public class TestspringbootApplication {
	private static final Logger log = LoggerFactory.getLogger(TestspringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestspringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
		};
	}
}
