package logone.digital.stagelink.stage;


import java.util.List;
import java.util.Optional;

public interface IStageService {
    StageDto create(StageEntity stage);

    List<StageDto> readAll();
    //StageDto readOneByDomaine(String domaine);

    StageDto update(StageDto stage);

    //void deleteOneById(Long id);
    void deleteOne(StageDto stage);

    StageEntity readOneByDomaine(String domaine);

    String deleteOneById(Long id);

}