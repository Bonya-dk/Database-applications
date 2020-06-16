package Lab4contd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int accountNumber;
	private String name;
	private int balance;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="employeeId")
	private Employee employee;
	
	@OneToMany(mappedBy="account",fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"employee","account"})
	//@JoinColumn(name="account")
	private List<Arrangement> arrangements = new ArrayList<Arrangement>();

	protected Account() {
	}

	public Account(int accountNumber,String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}



	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}

	public List<Arrangement> getArrangements() {
		return arrangements;
	}

	public void setArrangements(List<Arrangement> arrangements) {
		this.arrangements = arrangements;
	}
	
	
}
