package logone.digital.stagelink.etudiant;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDtoRequest {
    @NotNull(message = "Le nom est obligatoire")
    private String nom;
    @NotNull(message = "Le prenom est obligatoire")
    private String prenom;
    @NotNull(message = "Le competences est obligatoire")
    private String competences;
    @NotNull(message = "L' interet est obligatoire")
    private String interets;
    @NotNull(message = "Le parcours academique est obligatoire")
    private String parcoursAcademique;
    @NotNull(message = "Le numero telephone est obligatoire")
    private String telephone;
    @NotNull(message = "L' adresse est obligatoire")
    private String adresse;
    @NotNull(message = "Le mot de passe est obligatoire")
    private String motDePasse;
    private Instant dateInscription;
    private String statut;
    @NotNull(message = "L'email est obligatoire")
    private String email;
    private String roles;
}
