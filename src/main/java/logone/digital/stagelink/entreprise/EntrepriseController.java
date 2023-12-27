package logone.digital.stagelink.entreprise;


import jakarta.validation.Valid;
import logone.digital.stagelink.stage.StageEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/entreprises")
@AllArgsConstructor
public class EntrepriseController {

    final EntrepriseService entrepriseService;

    //POST http://localhost:8089/stage-link/api/v1/entreprises/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public ResponseEntity<EntrepriseDtoResponse> ajouterEntreprises(@RequestBody @Valid EntrepriseDtoRequest entrepriseDtoRequest)
    {
       return new ResponseEntity<>(entrepriseService.create(entrepriseDtoRequest),HttpStatus.CREATED);
    }

   // PUT http://localhost:8089/stage-link/api/v1/entreprises/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public EntrepriseDtoResponse modifierEntreprises(@RequestBody  @Valid  EntrepriseDtoRequest entreprise){

        return entrepriseService.update(entreprise, entreprise.getEmail());

    }
//
    //GET ALL http://localhost:8080/stage-link/api/v1/entreprises/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<EntrepriseDtoResponse> recupererEntreprises()
    {
        return  entrepriseService.readAll();
    }

//
    // DELETE http://localhost:8089/stage-link/api/v1/entreprises/supprimer/1
    @DeleteMapping(path = "/supprimer/{Entreprises}")
    @ResponseBody
    public void supprimerEntreprises
    (@PathVariable("Entreprises") String email)
    {
        entrepriseService.deleteOne(email);
    }


    // GET BY email http://localhost:8089/stage-link/api/v1/entreprises/recuperer/Entreprise
    @GetMapping(path = "/recuperer/{Entreprises}")
    @ResponseBody
    public EntrepriseDtoResponse recupererEntreprise(@PathVariable("Entreprises") String email)
    {
        return entrepriseService.readOneByEmail(email);
    }





}
