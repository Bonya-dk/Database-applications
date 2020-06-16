package Lab4contd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping()
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
//	@GetMapping("/viewAll")
//	public String viewEmployees(Model model) {
//		model.addAttribute("employeeList", employeeRepository.findAll());
//		return "employees";
//	}

	@GetMapping("/lastname/{name}")
	public List<Employee> findByLastName(@PathVariable String name) {
		return employeeRepository.findByLastName(name);
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		employeeRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		if (employee.getId() != id) {
			throw new IllegalArgumentException();
		}
		employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
		return employeeRepository.save(employee);
	}
}
