package logone.digital.stagelink.etudiant;

import jakarta.persistence.Column;
import logone.digital.stagelink.stage.StageDto;
import logone.digital.stagelink.stage.StageEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantDto {
    private Long id;

    private String prenom;
    private String matricule;
    private String competences;
    private String interets;
    private String parcoursAcademique;

    public  static EtudiantEntity toEntity(EtudiantDto etudiant) {

        if (etudiant == null) {
            return null;
        }

        return EtudiantEntity.builder()
                .id(etudiant.id)
                .prenom(etudiant.prenom)
                .matricule(etudiant.matricule)
                .competences(etudiant.competences)
                .interets(etudiant.interets)
                .parcoursAcademique(etudiant.parcoursAcademique)
                .build();
    }

    public  static EtudiantDto toDto(EtudiantEntity etudiant){

            if(etudiant == null){
                return null;
            }

            return EtudiantDto.builder()
                    .id(etudiant.getId())
                    .prenom(etudiant.getPrenom())
                    .matricule(etudiant.getMatricule())
                    .competences(etudiant.getCompetences())
                    .interets(etudiant.getInterets())
                    .parcoursAcademique(etudiant.getParcoursAcademique())
                    .build();

    }

}
