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

    private Long id;
    @Email(message = "l'adresse email est incorrect")
    private String email;
    private String motDePasse;
    private String roles;
    private String nomEntreprise;
    private String responsable;
    private String telephone;
    private String adresse;
    private Instant dateInscription;
    private  String statut ;


}
