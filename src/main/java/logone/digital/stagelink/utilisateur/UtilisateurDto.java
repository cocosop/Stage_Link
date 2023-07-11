package logone.digital.stagelink.utilisateur;

import jakarta.persistence.Column;
import logone.digital.stagelink.stage.StageDto;
import logone.digital.stagelink.stage.StageEntity;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
public class UtilisateurDto {

    protected Long id;
    protected String nom;
    protected String telephone;
    protected   String email;
    protected String adresse;
    protected String motDePasse;
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
