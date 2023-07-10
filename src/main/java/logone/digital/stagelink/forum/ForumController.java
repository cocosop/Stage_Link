package logone.digital.stagelink.forum;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequestMapping("/api/v1/forums")
@AllArgsConstructor
public class ForumController {
        private final ForumService forumService;
        @PostMapping("/add")
        @ResponseBody
        public ResponseEntity<ForumDto> add(
                @RequestBody @Validated ForumDto forumDto
        ){
            return  new ResponseEntity<>(forumService.create(forumDto), HttpStatus.CREATED);

        }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<ForumDto>> getAll()
    {
        return new ResponseEntity<>(
                forumService.getAll(),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteForum/{idForum}")
    @ResponseBody
    public ResponseEntity<ForumDto> deleteById(@PathVariable ("idForum") Integer id)
    {
        forumService.deleteById(id);
        return new  ResponseEntity<>(OK);
    }
    @PutMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<ForumDto> update(@RequestBody @Validated ForumDto forumDto){return new ResponseEntity<>(
            forumService.update(forumDto),
            OK);

    }
    }

