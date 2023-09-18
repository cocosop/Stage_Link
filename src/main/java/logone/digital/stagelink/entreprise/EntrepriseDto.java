package logone.digital.stagelink.entreprise;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;

@Data
@Builder
@Getter
@Setter
public class EntrepriseDto {

    private Long id;
    @NotNull(message = "Le nom du responsable est obligatoire")
    private String responsable;
    @NotNull(message = "Le nom de l'entreprise est obligatoire")
    private String nom;
    @NotNull(message = "Le numéro de telephone est obligatoire")
    private String telephone;
    @NotNull(message = "L' adresse email est obligatoire")
    private String email;
    @NotNull(message = "L'adresse est obligatoire")
    private String adresse;
    @NotNull(message = "Le mot de passe est obligatoire")
    private String motDePasse;
    @NotNull(message = "Le date d'inscription est obligatoire")
    private Instant dateInscription;

    public static EntrepriseEntity toEntity(EntrepriseDto entrepriseDto) {

        if (entrepriseDto == null) {
            return null;
        }

        return EntrepriseEntity.builder()
                .id(entrepriseDto.getId())
                .nom(entrepriseDto.getNom())
                .responsable(entrepriseDto.getResponsable())
                .email(entrepriseDto.getEmail())
                .adresse(entrepriseDto.getAdresse())
                .telephone(entrepriseDto.getTelephone())
                .motDePasse(entrepriseDto.getMotDePasse())
                .dateInscription(entrepriseDto.getDateInscription())
                .build();
    }
    public  static EntrepriseDto toDto(EntrepriseEntity entreprise) {

        if (entreprise == null) {
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .responsable(entreprise.getResponsable())
                .nom(entreprise.getNom())
                .telephone(entreprise.getTelephone())
                .email(entreprise.getEmail())
                .adresse(entreprise.getAdresse())
                .motDePasse(entreprise.getMotDePasse())
                .dateInscription(entreprise.getDateInscription())
                .build();

    }

}


