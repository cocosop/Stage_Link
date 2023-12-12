package logone.digital.stagelink.entreprise;

import logone.digital.stagelink.entreprise.EntrepriseDto;

import java.util.List;

public interface IEntrepriseService {

    //EntrepriseDto create(EntrepriseEntity entreprise);
    EntrepriseDto create(EntrepriseDto entrepriseDto);

    List<EntrepriseDto> readAll();

    EntrepriseDto readOneById(Long id);

    EntrepriseDto update(EntrepriseDto entreprise);

    //void deleteOneById(Long id);

    public String deleteOneById(Long id);

    void deleteOne(EntrepriseDto entreprise);
}
