package logone.digital.stagelink.etudiant;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
@AllArgsConstructor
public class EtudiantController {

    final EtudiantService etudiantService;

    //POST http://localhost:8080/stage-link/api/v1/etudiants/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public EtudiantDto ajouterEtudiants(@RequestBody @Valid EtudiantDto etudiant)
    {
        return etudiantService.
                create(etudiant);
    }

    //PUT http://localhost:8080/stage-link/api/v1/etudiants/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public EtudiantDto modifierEtudiants(@RequestBody  @Valid  EtudiantDto etudiant){

        return etudiantService.
                update(etudiant);
    }

    //GET http://localhost:8080/stage-link/api/v1/etudiants/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<EtudiantDto> recupererEtudiants()
    {
        return etudiantService.readAll();
    }

    // DELETE http://localhost:8080/stage-link/api/v1/etudiants/supprimer/1
    @DeleteMapping(path = "/supprimer/{idEtudiants}")
    @ResponseBody
    public void supprimerEtudiants
    (@PathVariable("idEtudiants") Long id)
    {
        etudiantService.deleteOneById(id);
    }
}
