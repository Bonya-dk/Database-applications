package Lab4contd;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = { AddressMapper.class, AccountMapper.class})	
public interface EmployeeMapper {
	@Mappings({
	      @Mapping(source = "customer.address", target = "addressDTO"),
	      @Mapping(source = "customer.accounts", target = "accountsDTO"),
	      @Mapping(source = "customer.firstName", target = "name")
	    })
	EmployeeDTO toDTO(Employee customer);
	
	@Mappings({
	 @Mapping(source = "customerDTO.addressDTO", target = "address"),
     @Mapping(source = "customerDTO.accountsDTO", target = "accounts"),
     @Mapping(source = "customerDTO.name", target = "firstName")
    })
	Employee toDAO(EmployeeDTO customerDTO);
}
