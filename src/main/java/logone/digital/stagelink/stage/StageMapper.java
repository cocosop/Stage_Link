package logone.digital.stagelink.stage;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface StageMapper {
@Mapping( target = "entreprise", source ="entreprise")
StageDtoResponse stageVersStageDto(StageEntity stage);
StageEntity stageDtoVersStage(StageDtoRequest stageDto);
}
