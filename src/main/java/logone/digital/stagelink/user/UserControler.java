package logone.digital.stagelink.user;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControler {

    private User user;
    @Autowired
    private UserService userService;

    // http://localhost:8089/stage-link/api/v1/user/search/email
//    @GetMapping(path = "/search/{email}")
//    @ResponseBody
//    public Optional<User> searchByNomEntreprise(@PathVariable("email") String email)
//    {
//        return userService.getAllUserByEmail(email);
//    }
}
