package logone.digital.stagelink.postulation;


import jakarta.validation.Valid;
import logone.digital.stagelink.etudiant.EtudiantDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postulations")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PostulationController {

    final PostulationService postulationService;


    //POST http://localhost:8089/stage-link/api/v1/postulations/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public ResponseEntity<PostulationDtoResponse> ajouterPostulations(@RequestBody @Valid PostulationDtoRequest postulation)
    {
        return new ResponseEntity<>(postulationService.create(postulation), HttpStatus.CREATED);
    }


    //PUT http://localhost:8089/stage-link/api/v1/postulations/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public PostulationDtoResponse modifierPostulation(@RequestBody  @Valid  PostulationDtoRequest postulation){

        return postulationService.
                update(postulation);
    }

    //GET http://localhost:8089/stage-link/api/v1/postulations/recuperer/email
    @GetMapping(path = "/recuperer/{email}")
    @ResponseBody
    public List<PostulationDtoResponse> recupererPostulation(@PathVariable("email") String email)
    {
        return postulationService.getAllPostulationByEmail(email);
    }


//    //GET by id http://localhost:8089/stage-link/api/v1/postulations/recuperer/1
//    @GetMapping(path = "/recuperer/{idPostulation}")
//    @ResponseBody
//    public PostulationDto recupererPostulation(@PathVariable("idPostulation") Long id)
//    {
//        return postulationServive.readOneById(id);
//    }


//    // DELETE http://localhost:8089/stage-link/api/v1/postulations/supprimer/1
//    @DeleteMapping(path = "/supprimer/{idPostulations}")
//    @ResponseBody
//    public void supprimerPostulation
//    (@PathVariable("idPostulations") Long id)
//    {
//        postulationServive.deleteOneById(id);
//    }
}
