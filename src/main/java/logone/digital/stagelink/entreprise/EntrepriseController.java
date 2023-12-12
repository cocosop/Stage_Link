package logone.digital.stagelink.entreprise;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entreprises")
@AllArgsConstructor
public class EntrepriseController {

    final EntrepriseService entrepriseService;

    //POST http://localhost:8080/stage-link/api/v1/entreprises/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public ResponseEntity<EntrepriseDto> ajouterEntreprises(@RequestBody @Valid EntrepriseDto entrepriseDto)
    {
       return new ResponseEntity<>(entrepriseService.create(entrepriseDto),HttpStatus.CREATED);
    }

    //PUT http://localhost:8080/stage-link/api/v1/entreprises/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public EntrepriseDto modifierEntreprises(@RequestBody  @Valid  EntrepriseDto entreprise){

        return entrepriseService.
                update(entreprise);

    }

    //GET http://localhost:8080/stage-link/api/v1/entreprises/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<EntrepriseDto> recupererEntreprises()
    {
        return entrepriseService.readAll();
    }


    // DELETE http://localhost:8080/stage-link/api/v1/entreprises/supprimer/1
    @DeleteMapping(path = "/supprimer/{idEntreprises}")
    @ResponseBody
    public void supprimerEntreprises
    (@PathVariable("idEntreprises") Long id)
    {
        entrepriseService.deleteOneById(id);
    }

    //http://localhost:8080/stage-link/api/v1/entreprises/recuperer/1
    @GetMapping(path = "/recuperer/{idEntreprises}")
    @ResponseBody
    public EntrepriseDto recupererEntreprise(@PathVariable("idEntreprises") Long id)
    {
        return entrepriseService.readOneById(id);
    }


}
