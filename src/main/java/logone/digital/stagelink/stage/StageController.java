package logone.digital.stagelink.stage;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stages")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StageController {

    final StageService stageService;


    //POST http://localhost:8089/stage-link/api/v1/stages/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    ResponseEntity<StageDtoResponse> ajouterStage(@RequestBody @Valid StageDtoRequest stage)
    {
        return new ResponseEntity<>(stageService.create(stage), HttpStatus.CREATED);
    }

    //GET http://localhost:8089/stage-link/api/v1/stages/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<StageDtoResponse> recupererStages()
    {
        return stageService.readAll();
    }

    //GET by nom_entreprise http://localhost:8089/stage-link/api/v1/stages/search/{nom_entreprise}
    @GetMapping(path = "/search/{email}")
    @ResponseBody
    public List <StageDtoResponse> searchByNomEntreprise(@PathVariable("email") String email)
    {
            return stageService.getAllStagesByNomEntreprise(email);
    }


    //PUT http://localhost:8089/stage-link/api/v1/stages/modifier
    @PutMapping(path = "/modifier/{idStage}")
    @ResponseBody
    public StageDtoResponse modifierStages(@RequestBody  @Valid  StageDtoRequest stage, @PathVariable(name = "idStage") Long idStage){

        return stageService.update(stage,idStage);
    }

    //GET by  id http://localhost:8089/stage-link/api/v1/stages/recuperer/1
    @GetMapping(path = "/recuperer/{idStage}")
    @ResponseBody
    public StageDtoResponse recupererStage(@PathVariable("idStage") Long id)
    {
        return stageService.readOneById(id);
    }




    // DELETE http://localhost:8089/stage-link/api/v1/stages/supprimer/1
    @DeleteMapping(path = "/supprimer/{idStages}")
    @ResponseBody
    public void supprimerStages
    (@PathVariable("idStages") Long idStage)
    {
        stageService.deleteOneById(idStage);

    }

    //GET http://localhost:8089/stage-link/api/v1/stages/recuperer-tous
//    @GetMapping(path = "/recupererAll")
//    @ResponseBody
//    public List<StageDtoResponse> recupererStagesByNbrePostulation()
//    {
//        return stageService.getAllStagesByNbrePostulation();
//    }


}
