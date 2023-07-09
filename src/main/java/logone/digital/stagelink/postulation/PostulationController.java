package logone.digital.stagelink.postulation;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postulations")
@AllArgsConstructor
public class PostulationController {

    final PostulationServive postulationServive;


    //POST http://localhost:8080/projet/api/v1/postulations/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public PostulationDto ajouterPostulation(@RequestBody @Valid PostulationDto postulation)
    {
        return postulationServive.
                create(postulation);
    }


    //PUT http://localhost:8080/projet/api/v1/postulations/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public PostulationDto modifierPostulation(@RequestBody  @Valid  PostulationDto postulation){

        return postulationServive.
                update(postulation);
    }

    //GET http://localhost:8089/projet/api/v1/postulations/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<PostulationDto> recupererPostulation()
    {
        return postulationServive.readAll();
    }



    // DELETE http://localhost:8089/projet/api/v1/postulation/supprimer/1
    @DeleteMapping(path = "/supprimer/{idPostulations}")
    @ResponseBody
    public void supprimerPostulation
    (@PathVariable("idPostulations") Long id)
    {
        postulationServive.deleteOneById(id);
    }
}
