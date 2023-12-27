package logone.digital.stagelink.stage;

import logone.digital.stagelink.entreprise.EntrepriseDtoRequest;
import logone.digital.stagelink.entreprise.EntrepriseDtoResponse;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Mapper(componentModel = "spring")
public interface StageMapper {
@Mapping( target = "entreprise", source ="entreprise")
StageDtoResponse stageVersStageDto(StageEntity stage);
StageEntity stageDtoVersStage(StageDtoRequest stageDto);
}
