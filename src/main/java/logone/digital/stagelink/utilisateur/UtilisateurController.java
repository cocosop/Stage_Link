package logone.digital.stagelink.utilisateur;
import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisareurs")
@AllArgsConstructor
public class UtilisateurController {

    final UtilisateurService utilisateurService;


    //POST http://localhost:8080/projet/api/v1/utilisateurs/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public UtilisateurDto ajouterUtilisateurs(@RequestBody @Valid UtilisateurDto utilisateur)
    {
        return utilisateurService.
                create(utilisateur);
    }

    //PUT http://localhost:8080/projet/api/v1/utilisateurs/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public UtilisateurDto modifierUtilisateurs(@RequestBody  @Valid  UtilisateurDto utilisateur){

        return utilisateurService.
                update(utilisateur);
    }
    //GET http://localhost:8080/projet/api/v1/utilisateurs/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<UtilisateurDto> recupererUtilisateur()
    {
        return utilisateurService.readAll();
    }

    // DELETE http://localhost:8080/projet/api/v1/utilisateurs/supprimer/1
    @DeleteMapping(path = "/supprimer/{idUtilisateurs}")
    @ResponseBody
    public void supprimerUtilisateurs
    (@PathVariable("idUtilisateurs") Long id)
    {
        utilisateurService.deleteOneById(id);
    }
}
