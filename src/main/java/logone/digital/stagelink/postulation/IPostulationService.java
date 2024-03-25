package logone.digital.stagelink.postulation;
import logone.digital.stagelink.etudiant.EtudiantAlreadyExistException;
import logone.digital.stagelink.etudiant.EtudiantDtoRequest;
import logone.digital.stagelink.stage.StageDtoResponse;

import java.util.List;
import java.util.Optional;

public interface IPostulationService {
    public PostulationDtoResponse create(PostulationDtoRequest postulation);


    PostulationDtoResponse update(PostulationDtoRequest postulation,Long idPostulation) throws EtudiantAlreadyExistException;

    List<PostulationDtoResponse> getAllPostulationByEmail(String email);
    List<PostulationDtoResponse> getAllPostulationByTitreStage(String titreStage);


     PostulationDtoResponse readOneById(Long idPostulation) ;



}
