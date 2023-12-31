package logone.digital.stagelink.etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    EtudiantDto create(EtudiantEntity etudiant);

    List<EtudiantDto> readAll();

    EtudiantDto readOneById(Long id);

    EtudiantDto update(EtudiantDto etudiant);

    //void deleteOneById(Long id);

    void deleteOne(EtudiantDto etudiant);

    public String deleteOneById(Long id);


}
