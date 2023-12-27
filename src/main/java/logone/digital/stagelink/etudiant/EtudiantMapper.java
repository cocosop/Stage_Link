package logone.digital.stagelink.etudiant;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    EtudiantDtoResponse etudiantVersEtudiantDto(EtudiantEntity etudiant);
    EtudiantEntity etudiantDtoVersEtudiant(EtudiantDtoRequest etudiantDto);
}
