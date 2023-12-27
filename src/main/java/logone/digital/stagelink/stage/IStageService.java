package logone.digital.stagelink.stage;


import java.util.List;
import java.util.Optional;

public interface IStageService {
    StageDtoResponse create(StageDtoRequest stage);

    List<StageDtoResponse> readAll();

//    StageDtoResponse update(StageDtoRequest stage, Long id);


//    StageDtoResponse update(StageDtoRequest stage, String nomEntreprise);

    StageDtoResponse update(StageDtoRequest stage, Long id);

    StageDtoResponse readOneById(Long id);

    void deleteOneById(Long id);

    public StageDtoResponse getStagesByNomEntreprise(String nomEntreprise);


}