package logone.digital.stagelink.postulation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface PostulationMapper {
    @Mapping( target = "stage", source ="stage")
    PostulationDtoResponse postulationVersPostulationDto(PostulationEntity postulationEntity);
    PostulationEntity postulationDtoVersPostulation(PostulationDtoRequest postulationDtoRequest);
}
