package Lab4contd;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArrangementMapper {
	Arrangement toDTO(Arrangement arrangement);
	Arrangement toDAO(Arrangement arrangementDTO);
}
