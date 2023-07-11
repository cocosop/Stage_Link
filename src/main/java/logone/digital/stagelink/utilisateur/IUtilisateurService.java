package logone.digital.stagelink.utilisateur;

import java.util.List;
import java.util.Optional;

public interface IUtilisateurService {
    UtilisateurDto create(UtilisateurDto utilisateur);

    List<UtilisateurDto> readAll();
    UtilisateurDto readOneById(Long id);

    UtilisateurDto update(UtilisateurDto utilisateur);

    void deleteOneById(Long id);
    void deleteOne(UtilisateurDto utilisateur);
}
