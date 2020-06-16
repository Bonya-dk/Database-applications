package Lab4contd;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Arrangement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long arrangementId;
	private double amount;
	private String date;
	
	@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="employeeId")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="accountId")
	@JsonIgnoreProperties({"employee"})
	private Account account;

	protected Arrangement() {
	}

	public Arrangement(double amount, String date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	public long getId() {
		return arrangementId;
	}
	
	public double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public void setId(long id) {
		this.arrangementId = id;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getArrangementId() {
		return arrangementId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Account getAccount() {
		return account;
	}

	public void setArrangementId(long arrangementId) {
		this.arrangementId = arrangementId;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setAccount(Account account) {
		this.account = account;
	}



}
