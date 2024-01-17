package logone.digital.stagelink.postulation;
import logone.digital.stagelink.etudiant.EtudiantAlreadyExistException;
import logone.digital.stagelink.etudiant.EtudiantDtoRequest;
import logone.digital.stagelink.stage.StageDtoResponse;

import java.util.List;
import java.util.Optional;

public interface IPostulationService {
    public PostulationDtoResponse create(PostulationDtoRequest postulation);

    List<PostulationDtoResponse> readAll();

    PostulationDtoResponse readOneById(Long id);

    PostulationDtoResponse update(PostulationDtoRequest postulation) throws EtudiantAlreadyExistException;

    void deleteOneById(Long idPostulation);

    List<PostulationDtoResponse> getAllPostulationByEmail(String email);

//    List<PostulationDtoResponse> readAll();

//    PostulationDtoResponse readOneById(Long id);

//    PostulationDtoResponse update(PostulationDtoRequest postulation) throws EtudiantAlreadyExistException;

//    void deleteOneById(Long idPostulation);



//    List<PostulationDtoResponse> getAllPostulationByEmail(String email);


    //    void deleteOneById(Long id);
//    void deleteOne(PostulationDtoResponse postulation);
}
