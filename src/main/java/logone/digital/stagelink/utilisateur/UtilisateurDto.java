package logone.digital.stagelink.utilisateur;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import logone.digital.stagelink.stage.StageDto;
import logone.digital.stagelink.stage.StageEntity;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
public class UtilisateurDto {

    protected Long id;
    @NotNull(message = "Le nom est obligatoire")
    protected String nom;
    @Pattern(regexp = "\\d{10}", message = "Le numéro de téléphone doit contenir 10 chiffres")
    @NotNull(message = "Le numéro de téléphone est obligatoire")
    protected String telephone;
    @Email(message = "L'adresse email n'est pas valide")
    protected   String email;
    @NotNull(message = "L'adresse est obligatoire")
    protected String adresse;
    @NotNull(message = "L'adresse est obligatoire")
    protected String motDePasse;
    @NotNull(message = "L'adresse est obligatoire")
    protected Instant dateInscription;

    public  static UtilisateurEntity toEntity(UtilisateurDto utilisateur){

        if(utilisateur == null){
            return null;
        }

        return UtilisateurEntity.builder()
                .id(utilisateur.id)
                .nom(utilisateur.nom)
                .telephone(utilisateur.telephone)
                .email(utilisateur.email)
                .adresse(utilisateur.adresse)
                .motDePasse(utilisateur.motDePasse)
                .dateInscription(utilisateur.dateInscription)
                .build();
    }

    public  static UtilisateurDto toDto(UtilisateurEntity utilisateur){

        if(utilisateur == null){
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .telephone(utilisateur.getTelephone())
                .email(utilisateur.getEmail())
                .adresse(utilisateur.getAdresse())
                .motDePasse(utilisateur.getMotDePasse())
                .dateInscription(utilisateur.getDateInscription())
                .build();
    }

}
