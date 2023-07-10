package logone.digital.stagelink.commentaire;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequestMapping("/api/v1/commentaires")
@AllArgsConstructor
public class CommentaireController {
    private final CommentaireService commentaireService;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<CommentaireDto> add( @Validated
            @RequestBody CommentaireDto commentaireDto
    ){
       return  new ResponseEntity<>(commentaireService.create(commentaireDto), HttpStatus.CREATED);

    }
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<CommentaireDto>> getAll()
    {
        return new ResponseEntity<>(
                commentaireService.getAll(),
                OK);
    }
    @DeleteMapping(path = "/deleteCommentaire/{idCommentaire}")
    @ResponseBody
    public ResponseEntity<CommentaireDto> deleteById(@PathVariable ("idCommentaire") Integer id)
    {
        commentaireService.deleteById(id);
      return new  ResponseEntity<>(OK);
    }
    @PutMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<CommentaireDto> update(@Validated @RequestBody CommentaireDto commentaireDto){return new ResponseEntity<>(
            commentaireService.update(commentaireDto),
            OK);

    }
}
