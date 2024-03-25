package logone.digital.stagelink.postulation;
import jakarta.validation.Valid;
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
    final PostulationRepository postulationRepository;
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
                update(postulation, postulation.getIdPostulation());
    }
    //GET http://localhost:8089/stage-link/api/v1/postulations/recuperer/email
    @GetMapping(path = "/recuperer/{email}")
    @ResponseBody
    public List<PostulationDtoResponse> recupererPostulation(@PathVariable("email") String email)
    {
        return postulationService.getAllPostulationByEmail(email);
    }



    @GetMapping(path = "/recupererStage/{titreStage}")
    @ResponseBody
    public List<PostulationDtoResponse>recupererPostulationById(@PathVariable("titreStage") String titreStage)
    {
        return postulationService.getAllPostulationByTitreStage(titreStage);
    }


    //GET by id http://localhost:8089/stage-link/api/v1/postulations/recupererPostulation/1
    @GetMapping(path = "/recupererPostulation/{idPostulation}")
    @ResponseBody
    public PostulationDtoResponse recupererPostulation(@PathVariable("idPostulation") Long idPostulation)
    {
        return postulationService.readOneById(idPostulation);
    }


//    // DELETE http://localhost:8089/stage-link/api/v1/postulations/supprimer/1
//    @DeleteMapping(path = "/supprimer/{idPostulations}")
//    @ResponseBody
//    public void supprimerPostulation
//    (@PathVariable("idPostulations") Long id)
//    {
//        postulationServive.deleteOneById(id);
//    }


    // GET http://localhost:8089/stage-link/api/v1/compter/1
    @GetMapping(path = "/compter/{idStage}")
    @ResponseBody
    public Long compterPostulation
    (@PathVariable("idStage") Long idStage)
    {
        return postulationRepository.countAllByStage_IdStage(idStage);
    }
}
