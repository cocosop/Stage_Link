package logone.digital.stagelink.stage;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
@AllArgsConstructor
public class StageController {

    final StageService stageService;


    //POST http://localhost:8080/projet/api/v1/stages/ajouter
    @PostMapping(path = "/ajouter")
    @ResponseBody
    public StageDto ajouterStages(@RequestBody @Valid StageDto stage)
    {
        return stageService.
                create(stage);
    }


    //PUT http://localhost:8080/projet/api/v1/stages/modifier
    @PutMapping(path = "/modifier")
    @ResponseBody
    public StageDto modifierStages(@RequestBody  @Valid  StageDto stage){

        return stageService.
                update(stage);
    }

    //GET http://localhost:8080/projet/api/v1/stage/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public List<StageDto> recupererStages()
    {
        return stageService.readAll();
    }



    // DELETE http://localhost:8080/projet/api/v1/stages/supprimer/1
    @DeleteMapping(path = "/supprimer/{idStages}")
    @ResponseBody
    public void supprimerStages
    (@PathVariable("idStage") Long id)
    {
        stageService.deleteOneById(id);
    }
}
