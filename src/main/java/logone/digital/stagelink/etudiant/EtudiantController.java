package logone.digital.stagelink.etudiant;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
@AllArgsConstructor
public class EtudiantController {

    final EtudiantService etudiantService;

    //POST http://localhost:8089/stage-link/api/v1/etudiants/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public ResponseEntity<EtudiantDtoResponse> ajouterEtudiant(@RequestBody @Valid EtudiantDtoRequest etudiantDtoRequest)
    {
        return new ResponseEntity<>(etudiantService.create(etudiantDtoRequest),HttpStatus.CREATED);
    }

    //PUT http://localhost:8089/stage-link/api/v1/etudiants/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public EtudiantDtoResponse modifierEtudiants(@RequestBody  @Valid  EtudiantDtoRequest etudiant){

        return etudiantService.
                update(etudiant, etudiant.getEmail());
    }

      //GET ALL http://localhost:8089/stage-link/api/v1/etudiants/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<EtudiantDtoResponse> recupererEtudiants()
    {
        return etudiantService.readAll();
    }

    // DELETE http://localhost:8080/stage-link/api/v1/etudiants/supprimer/1
    @DeleteMapping(path = "/supprimer/{Etudiants}")
    @ResponseBody
    public void supprimerEtudiants
    (@PathVariable("Etudiants") String email)
    {
        etudiantService.deleteOne(email);
    }
//
    //GET by id http://localhost:8089/stage-link/api/v1/etudiants/recuperer/1
    @GetMapping(path = "/recuperer/{Etudiants}")
    @ResponseBody
    public EtudiantDtoResponse recupererEtudiant(@PathVariable("Etudiants") String email)
    {
        return etudiantService.readOneByEmail(email);
    }



}
