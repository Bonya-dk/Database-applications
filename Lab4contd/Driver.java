package Lab4contd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Driver {

	private static final Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		 SpringApplication.run(Driver.class);		
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository employeeRepository, AccountRepository accountRepository,
			ArrangementRepository arrangementRepository, AddressRepository addressRepository) {
		return (args) -> {
			// sample data
			Employee employee1 = new Employee("Daniil", "Daniil");
			Employee employee2 = new Employee("Davronbek", "Sattorov");
			employeeRepository.save(employee1);
			employeeRepository.save(employee2);

			Address address1 = new Address(11, "green", "almaty", "Kazakhtan");
			Address address2 = new Address(22, "red", "london", "England");
			addressRepository.save(address1);
			addressRepository.save(address2);

			employee1.setAddress(address1);
			employee2.setAddress(address2);
			employeeRepository.save(employee1);
			employeeRepository.save(employee2);

			Account account1 = new Account(2104832, "Daniil", 132);
			Account account2 = new Account(2918293, "Davron", 430);
			accountRepository.save(account1);
			accountRepository.save(account2);

			employee1.getAccounts().add(account1);
			employee2.getAccounts().add(account2);

			Arrangement arrangement1 = new Arrangement(12, "11th April");
			Arrangement arrangement2 = new Arrangement(65, "16th April");
			Arrangement arrangement3 = new Arrangement(99, "5th April");

			account1.getArrangements().add(arrangement1);
			account1.getArrangements().add(arrangement2);
			account2.getArrangements().add(arrangement3);

			arrangement1.setEmployee(employee1);
			arrangement2.setEmployee(employee1);
			arrangement3.setEmployee(employee2);

			arrangement1.setAccount(account1);
			arrangement2.setAccount(account1);
			arrangement3.setAccount(account2);

			arrangementRepository.save(arrangement1);
			arrangementRepository.save(arrangement2);
			arrangementRepository.save(arrangement3);

			account1.setEmployee(employee1);
			account2.setEmployee(employee2);
			accountRepository.save(account1);
			accountRepository.save(account2);

			// fetch all employees
			log.info("Employees found with findAll():");
			log.info("-------------------------------");
			for (Employee employee : employeeRepository.findAll()) {
				log.info(employee.toString());
			}
			log.info("");

			// fetch all address
			log.info("Address found with findAll():");
			log.info("-------------------------------");
			for (Address address : addressRepository.findAll()) {
				log.info(address.toString());
			}
			log.info("");

			// fetch all arrangements
			log.info("Arrangements found with findAll():");
			log.info("-------------------------------");
			for (Arrangement arrangement : arrangementRepository.findAll()) {
				log.info(arrangement.toString());
			}
			log.info("");

			// fetch all accounts
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account : accountRepository.findAll()) {
				log.info(account.toString());
			}
			log.info("");

			// fetch accounts by balances
			log.info("Account(s) found with findByBalanceBetween(100,500)");
			log.info("--------------------------------");
			for (Account account : accountRepository.findByBalanceBetween(100, 500)) {
				log.info(account.toString());
			}
			log.info("");

			// fetch account by last name
			log.info("Account found with findByNameStartingWith(\"acc\")");
			log.info("--------------------------------------------");
			accountRepository.findByNameStartingWith("acc").forEach(result -> {
				log.info(result.toString());
			});
			log.info("");

			// fetch an individual employee by ID
			Employee employee = employeeRepository.findById(1L);
			log.info("Employee found with findById(1L):");
			log.info("--------------------------------");
			log.info(employee.toString());
			log.info("");

			// fetch employees by last name
			log.info("Employee found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			employeeRepository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Employee bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}