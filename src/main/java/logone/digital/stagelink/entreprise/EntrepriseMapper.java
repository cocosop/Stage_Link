package logone.digital.stagelink.entreprise;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@Mapper(componentModel = "spring")
public interface EntrepriseMapper {

    EntrepriseDtoResponse entrepriseVersEntrepriseDto(EntrepriseEntity entreprise);
    EntrepriseEntity entrepriseDtoVersEntreprise(EntrepriseDtoRequest entrepriseDto);
}
