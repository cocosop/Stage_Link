package logone.digital.stagelink.entreprise;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseDtoResponse {

    @Email(message = "l'adresse email est incorrect")
    private String email;
    private String password;
    private String nomEntreprise;
    private String responsable;
    private String telephone;
    private String adresse;
    private String logo;
    private Instant dateInscription;



}
