package logone.digital.stagelink.postulation;


import jakarta.validation.Valid;
import logone.digital.stagelink.entreprise.EntrepriseDto;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postulations")
@AllArgsConstructor
public class PostulationController {

    final PostulationServive postulationServive;


    //POST http://localhost:8080/stage-link/api/postulations/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public ResponseEntity<PostulationDto> ajouterPostulations(@RequestBody @Valid PostulationEntity postulation)
    {
        return new ResponseEntity<>(postulationServive.create(postulation), HttpStatus.CREATED);
    }


    //PUT http://localhost:8080/stage-link/api/v1/postulations/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public PostulationDto modifierPostulation(@RequestBody  @Valid  PostulationDto postulation){

        return postulationServive.
                update(postulation);
    }

    //GET http://localhost:8080/stage-link/api/v1/postulations/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<PostulationDto> recupererPostulation()
    {
        return postulationServive.readAll();
    }



    // DELETE http://localhost:8080/stage-link/api/v1/postulation/supprimer/1
    @DeleteMapping(path = "/supprimer/{idPostulations}")
    @ResponseBody
    public void supprimerPostulation
    (@PathVariable("idPostulations") Long id)
    {
        postulationServive.deleteOneById(id);
    }
}
