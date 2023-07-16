package logone.digital.stagelink.stage;



import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
public class StageDto {

    private Long id;
    private String titre;
    private String description;
    private String entreprise;
    private String domaine;
    private String localisation;
    private Instant dateDebut;
    private Instant dateFin;

    public  static StageEntity toEntity(StageDto stage){

        if(stage == null){
            return null;
        }

        return StageEntity.builder()
                .id(stage.id)
                .entreprise(stage.entreprise)
                .titre(stage.titre)
                .description(stage.description)
                .domaine(stage.domaine)
                .localisation(stage.localisation)
                .dateDebut(stage.dateDebut)
                .dateFin(stage.dateFin)
                .build();
    }

    public  static StageDto toDto(StageEntity stage){

        if(stage == null){
            return null;
        }

        return StageDto.builder()
                .id(stage.getId())
                .entreprise(stage.getEntreprise())
                .titre(stage.getTitre())
                .description(stage.getDescription())
                .domaine(stage.getDomaine())
                .localisation(stage.getLocalisation())
                .dateDebut(stage.getDateDebut())
                .dateFin(stage.getDateDebut())
                .build();
    }
}

