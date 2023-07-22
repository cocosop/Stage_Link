package logone.digital.stagelink.user;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    // Build Add User REST API
    //POST http://localhost:8080/stage-link/api/v1/users/ajouter
    @PostMapping("/ajouter")
    @ResponseBody
    public ResponseEntity<UserDto> ajouterUsers(
            @RequestBody @Valid UserDto user)
    {
        UserDto savedUser = userService.create(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build Get Users REST API
    //GET http://localhost:8080/stage-link/api/v1/users/recuperer-tous
    @GetMapping(path = "/recuperer-tous")
    @ResponseBody
    public ResponseEntity<List<UserDto>> recupererUsers(){
        List<UserDto> users = userService.readAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    //PUT http://localhost:8080/stage-link/api/v1/users/modifier
    @PutMapping("/modifier")
    @ResponseBody
    public ResponseEntity<UserDto> modifierUsers(
            @RequestBody @Valid UserDto user)
    {
        UserDto updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    // http://localhost:8089/stage-link/api/v1/users/supprimer/8
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<String> supprimerUser(
            @PathVariable("id") Long userId)
    {

        return new ResponseEntity<>(userService.deleteOneById(userId),
                HttpStatus.OK);
    }



}
