package logone.digital.stagelink.login;

import jakarta.validation.Valid;
import logone.digital.stagelink.user.User;
import logone.digital.stagelink.user.UserDtoResponse;
import logone.digital.stagelink.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    //http://localhost:8089/stage-link/api/v1/auth/connect
    @PostMapping("/connect")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody @Valid LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()

                )
        );
       SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(this.userService.readOneByEmail(loginDto.getEmail()), HttpStatus.OK);
    }


}
