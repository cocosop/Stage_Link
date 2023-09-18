package logone.digital.stagelink.etudiant;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;

@Data
@Builder
public class EtudiantDto {
    private Long id;
    @NotNull(message = "Le nom est obligatoire")
    private String nom;
    @NotNull(message = "Le prenom est obligatoire")
    private String prenom;
    @Pattern(regexp = "[0-9]*")
    @Size(min = 9, max = 9, message = "Zip code should be of size {max}")
    @NotNull(message = "Le matricule est obligatoire")
    private String matricule;
    @NotNull(message = "Le competences est obligatoire")
    private String competences;
    @NotNull(message = "L' interet est obligatoire")
    private String interets;
    @NotNull(message = "Le parcours academique est obligatoire")
    private String parcoursAcademique;
    @NotNull(message = "Le numero telephone est obligatoire")
    private String telephone;
    @NotNull(message = "L'email est obligatoire")
    private String email;
    @NotNull(message = "L' adresse est obligatoire")
    private String adresse;
    @NotNull(message = "Le mot de passe est obligatoire")
    private String motDePasse;
    @NotNull(message = "La date d'inscription est obligatoire")
    private Instant dateInscription;

    private boolean active;

    public void message(){

    }

    public  static EtudiantEntity toEntity(EtudiantDto etudiantDto) {

        if (etudiantDto == null) {
            return null;
        }



        return EtudiantEntity.builder()
                .id(etudiantDto.getId())
                .nom(etudiantDto.getNom())
                .prenom(etudiantDto.getPrenom())
                .telephone(etudiantDto.getTelephone())
                .matricule(etudiantDto.getMatricule())
                .competences(etudiantDto.getCompetences())
                .interets(etudiantDto.getInterets())
                .parcoursAcademique(etudiantDto.getParcoursAcademique())
                .email(etudiantDto.getEmail())
                .adresse(etudiantDto.getAdresse())
                .motDePasse(etudiantDto.getMotDePasse())
                .dateInscription(etudiantDto.getDateInscription())
                .build();
    }

    public  static EtudiantDto toDto(EtudiantEntity etudiant){

            if(etudiant == null){
                return null;
            }

            return EtudiantDto.builder()
                    .id(etudiant.getId())
                    .nom(etudiant.getNom())
                    .prenom(etudiant.getPrenom())
                    .telephone(etudiant.getTelephone())
                    .matricule(etudiant.getMatricule())
                    .email(etudiant.getEmail())
                    .adresse(etudiant.getAdresse())
                    .motDePasse(etudiant.getMotDePasse())
                    .dateInscription(etudiant.getDateInscription())
                    .competences(etudiant.getCompetences())
                    .interets(etudiant.getInterets())
                    .parcoursAcademique(etudiant.getParcoursAcademique())
                    .build();

    }

}
