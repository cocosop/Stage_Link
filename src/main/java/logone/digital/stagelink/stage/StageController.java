package logone.digital.stagelink.stage;


import jakarta.validation.Valid;
import logone.digital.stagelink.etudiant.EtudiantDto;
import logone.digital.stagelink.etudiant.EtudiantEntity;
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


    //POST http://localhost:8080/stage-link/api/v1/stages/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    ResponseEntity<StageDto> ajouterStage(@RequestBody @Valid StageEntity stage)
    {
        return new ResponseEntity<>(stageService.create(stage), HttpStatus.CREATED);
    }


    //PUT http://localhost:8080/stage-link/api/v1/stages/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public StageDto modifierStages(@RequestBody  @Valid  StageDto stage){

        return stageService.
                update(stage);
    }

    //GET http://localhost:8080/stage-link/api/v1/stage/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<StageDto> recupererStages()
    {
        return stageService.readAll();
    }



    // DELETE http://localhost:8080/stage-link/api/v1/stages/supprimer/1
    @DeleteMapping(path = "/supprimer/{idStages}")
    @ResponseBody
    public void supprimerStages
    (@PathVariable("idStages") Long id)
    {
        stageService.deleteOneById(id);
    }
}
