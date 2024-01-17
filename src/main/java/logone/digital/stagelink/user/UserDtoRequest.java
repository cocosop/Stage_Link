package logone.digital.stagelink.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {
    @NotNull(message = "Le mot de passe est obligatoire")
    private String password;
    @NotNull(message = "L'email est obligatoire")
    private String email;
    private String roles;
}
