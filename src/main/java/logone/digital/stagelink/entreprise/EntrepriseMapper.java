package logone.digital.stagelink.entreprise;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {
    EntrepriseDto entrepriseVersEntrepriseDto(EntrepriseEntity entreprise);
    EntrepriseEntity entrepriseDtoVersEntreprise(EntrepriseDto entrepriseDto);
}
