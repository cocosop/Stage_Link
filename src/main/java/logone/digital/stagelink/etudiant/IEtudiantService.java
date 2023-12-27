package logone.digital.stagelink.etudiant;

import java.util.List;

public interface IEtudiantService {

    EtudiantDtoResponse create(EtudiantDtoRequest etudiant);

    List<EtudiantDtoResponse> readAll();

    EtudiantDtoResponse readOneByEmail(String email);

    EtudiantDtoResponse update(EtudiantDtoRequest etudiant, String email);

    //void deleteOneById(Long id);

    void deleteOne(String email);





}
