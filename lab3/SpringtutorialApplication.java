package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class SpringtutorialApplication {

  private static final Logger log = LoggerFactory.getLogger(SpringtutorialApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringtutorialApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository, AccountRepository accountRepository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
      
      log.info("=======================================");
      

      
      
      log.info("Get accounts, which balance is in between desired values.");
      List<Account> account = accountRepository.findByBalanceBetween(1000, 2000);
      log.info(account.toString());
      log.info("---------------------------------------------");
      for (Account startWith: accountRepository.findByNameStartingWith("D")) {
    	  log.info(startWith.toString());
      }
      log.info("---------------------------------------------");
      
      log.info("Get accounts by id.");
      for (Account findid: accountRepository.findById(8)) {
    	  log.info(findid.toString());
      } 
      };
  
  }
}
  

