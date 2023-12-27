package logone.digital.stagelink.etudiant;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDtoResponse  {

    private Long id;
    private String nom;
    private String prenom;
    private String competences;
    private String interets;
    private String parcoursAcademique;
    private String telephone;
    private String adresse;
    private String motDePasse;
    private Instant dateInscription;
    private String statut;
    private String email;
    private String roles;



//    public  static EtudiantEntity toEntity(EtudiantDto etudiantDto) {
//
//        if (etudiantDto == null) {
//            return null;
//        }
//        return EtudiantEntity.builder()
//                .id(etudiantDto.getId())
//                .nom(etudiantDto.getNom())
//                .prenom(etudiantDto.getPrenom())
//                .telephone(etudiantDto.getTelephone())
//                .matricule(etudiantDto.getMatricule())
//                .competences(etudiantDto.getCompetences())
//                .interets(etudiantDto.getInterets())
//                .parcoursAcademique(etudiantDto.getParcoursAcademique())
//                .statut(etudiantDto.getStatut())
//                .adresse(etudiantDto.getAdresse())
//                .dateInscription(etudiantDto.getDateInscription())
//                .nom(etudiantDto.getNom())
//                .build();
//    }
//
//    public  static EtudiantDto toDto(EtudiantEntity etudiant){
//            if(etudiant == null){
//                return null;
//            }
//            return EtudiantDto.builder()
//                    .idEtudiant(etudiant.getIdEtudiant())
//                    .nom(etudiant.getNom())
//                    .prenom(etudiant.getPrenom())
//                    .telephone(etudiant.getTelephone())
//                    .matricule(etudiant.getMatricule())
//                    .adresse(etudiant.getAdresse())
//                    .dateInscription(etudiant.getDateInscription())
//                    .competences(etudiant.getCompetences())
//                    .interets(etudiant.getInterets())
//                    .statut(etudiant.getStatut())
//                    .parcoursAcademique(etudiant.getParcoursAcademique())
//                    .build();
//
//    }

}
