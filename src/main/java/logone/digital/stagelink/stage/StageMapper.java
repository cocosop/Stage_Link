package logone.digital.stagelink.stage;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StageMapper {
    StageDto stageVersStageDto(StageEntity stage);
}
