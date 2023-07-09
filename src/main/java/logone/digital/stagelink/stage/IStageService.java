package logone.digital.stagelink.stage;


import java.util.List;
import java.util.Optional;

public interface IStageService {
    StageDto create(StageDto stage);

    List<StageDto> readAll();
    StageDto readOneById(Long id);

    StageDto update(StageDto stage);

    void deleteOneById(Long id);
    void deleteOne(StageDto stage);
}
