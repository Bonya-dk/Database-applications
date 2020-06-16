package Lab4contd;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ArrangementMapper.class })
public interface AccountMapper {

	@Mapping(source="account.arrangements", target="arrangementsDTO")
	AccountDTO toDTO(Account account);
	
	@Mapping(source="accountDTO.arrangementsDTO", target="arrangements")
	Account toDAO(AccountDTO accountDTO);
}
