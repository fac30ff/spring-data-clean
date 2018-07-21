package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySuperTest {
    private static final Logger log = LoggerFactory.getLogger(MySuperTest.class);

    private void addAll(CustomerRepository repository) {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
    }

    private void printById(CustomerRepository repository, long id) {
        repository.findById(id)
                .ifPresent(customer -> {
                    log.info("Customer found with findById(1L):");
                    log.info("--------------------------------");
                    log.info(customer.toString());
                    log.info("");
                });
    }

    private void printAll(CustomerRepository repository) {
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");
    }

    private void printByName(CustomerRepository repository, String name) {
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //addAll(repository);
                printAll(repository);
                //printById(repository, 1);
                //printByName(repository, "Bauer");
            }
        };
    }
}
