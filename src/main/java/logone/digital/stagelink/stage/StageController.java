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
    @GetMapping(path = "/search/{nom_entreprise}")
    @ResponseBody
    public StageDtoResponse searchByNomEntreprise(@PathVariable("nom_entreprise") String nom_entreprise)
    {
            return stageService.getStagesByNomEntreprise(nom_entreprise);
    }


    //PUT http://localhost:8089/stage-link/api/v1/stages/modifier
    @PutMapping(path = "/modifier/{id}")
    @ResponseBody
    public StageDtoResponse modifierStages(@RequestBody  @Valid  StageDtoRequest stage, @PathVariable(name = "id") Long id){

        return stageService.update(stage,id);
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
    (@PathVariable("idStages") Long id)
    {
        stageService.deleteOneById(id);

    }
}
