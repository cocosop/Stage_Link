package logone.digital.stagelink.entreprise;

import java.util.List;

public interface IEntrepriseService {


    EntrepriseDtoResponse create(EntrepriseDtoRequest entreprise);
    List<EntrepriseDtoResponse> readAll();

    EntrepriseDtoResponse readOneByEmail(String email);
//
    EntrepriseDtoResponse update(EntrepriseDtoRequest entreprise, String email);

    //void deleteOneById(Long id);

//    public String deleteOneById(Long id);

    void deleteOne(String email);
}
