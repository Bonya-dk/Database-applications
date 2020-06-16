package Lab4contd;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {
	private String name; // = employee.firstname+employee.fullname
	private AddressDTO addressDTO;
	private List<AccountDTO> accountsDTO=new ArrayList<AccountDTO>();
	
	public EmployeeDTO() {
		
	}
	public EmployeeDTO(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	public List<AccountDTO> getAccountsDTO() {
		return accountsDTO;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	public void setAccountsDTO(List<AccountDTO> accountsDTO) {
		this.accountsDTO = accountsDTO;
	}
	
	
}
