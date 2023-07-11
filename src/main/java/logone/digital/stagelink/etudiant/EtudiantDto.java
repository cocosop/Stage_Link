package logone.digital.stagelink.etudiant;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Builder
@Data //@Data regroupe @Getter,@Setter, @AllArgsConstructor,@toString,@NoArgs etc.
public class EtudiantDto {

    // Votre TODO: Faites les recherches la Validation avec Spring Validation

    private Long id;

    @NotNull(message = "Le prénom est obligatoire")
    private String prenom;

    @NotNull(message = "Le matricule est obligatoire")
    private String matricule;

    @Pattern(regexp = "\\d{10}", message = "Le numéro de téléphone doit contenir 10 chiffres")
    private String telephone;

    private String interet;

    @NotNull(message = "Les competences sont obligatoire")
    private String competences;

    @NotNull(message = "Le parcoursAcadémique est obligatoire")
    private String parcoursAcadémique;


    public static EtudiantDto toDto
            (EtudiantEntity etudiant)
    {

        if(etudiant == null){
            //Mon TODO Throw an exception
            return null;
        }

        return EtudiantDto.builder()
                .id(etudiant.getId())
                .prenom(etudiant.getPrenom())
                .matricule(etudiant.getMatricule())
                .interet(etudiant.getInteret())
                .competences(etudiant.getCompetences())
                .parcoursAcadémique(etudiant.getParcoursAcadémique())
                .build();
    }

    public static EtudiantEntity toEntity
            (EtudiantDto etudiantDto)
    {

        if(etudiantDto == null){
            //mon TODO Throw an exception
            return null;
        }

        return EtudiantEntity.builder()
                .id(etudiantDto.getId())
                .prenom(etudiantDto.getPrenom())
                .matricule(etudiantDto.getMatricule())
                .competences(etudiantDto.getCompetences())
                .interet(etudiantDto.getInteret())
                .parcoursAcadémique(etudiantDto.getParcoursAcadémique())
                .build();
    }
}

