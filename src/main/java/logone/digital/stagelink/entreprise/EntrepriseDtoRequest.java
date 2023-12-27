package logone.digital.stagelink.entreprise;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import logone.digital.stagelink.stage.StageEntity;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseDtoRequest {

   @Email(message = "l'adresse email est incorrect")
   @NotNull(message = "l'adresse email est obligatoire")
    private String email;
    @NotNull(message = "le nom de l'entreprise est obligatoire")
    private String motDePasse;
    private String roles;
    @NotNull(message = "le nom de l'entreprise est obligatoire")
    private String nomEntreprise;
    @NotNull(message = "Le nom du responsable est obligatoire")
    private String responsable;
    @NotNull(message = "Le numéro de telephone est obligatoire")
    private String telephone;
    @NotNull(message = "L'adresse est obligatoire")
    private String adresse;
    private Instant dateInscription;
    private  String statut ;


//    public static EntrepriseEntity toEntity(EntrepriseDto entrepriseDto) {
//
//        if (entrepriseDto == null) {
//            return null;
//        }
//
//        return EntrepriseEntity.builder()
//                .id(entrepriseDto.getId())
//                .nomEntreprise(entrepriseDto.getNomEntreprise())
//                .responsable(entrepriseDto.getResponsable())
//                .adresse(entrepriseDto.getAdresse())
//                .telephone(entrepriseDto.getTelephone())
//                .dateInscription(entrepriseDto.getDateInscription())
//                .statut(entrepriseDto.getStatut())
//                .build();
//    }
//    public  static EntrepriseDto toDto(EntrepriseEntity entreprise) {
//
//        if (entreprise == null) {
//            return null;
//        }
//
//        return EntrepriseDto.builder()
//                .id(entreprise.getId())
//                .responsable(entreprise.getResponsable())
//                .nomEntreprise(entreprise.getNomEntreprise())
//                .telephone(entreprise.getTelephone())
//                .email(entreprise.getEmail())
//                .adresse(entreprise.getAdresse())
//                .motDePasse(entreprise.getMotDePasse())
//                .dateInscription(entreprise.getDateInscription())
//                .statut(entreprise.getStatut())
//                .build();
//
//    }

}


