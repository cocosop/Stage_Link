package logone.digital.stagelink.stage;



import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
public class StageDto {

    private Long id;
    @NotNull(message = "Le titre est obligatoire")
    private String titre;
    @NotNull(message = "La description est obligatoire")
    private String description;
    @NotNull(message = "L' entreprise est obligatoire")
    private String nomEntreprise;
    @NotNull(message = "Le domaine est obligatoire")
    private String domaine;
    @NotNull(message = "La localisation est obligatoire")
    private String localisation;
    @NotNull(message = "Le date de debut est obligatoire")
    private Instant dateDebut;
    @NotNull(message = "Le date de fin est obligatoire")
    private Instant dateFin;

    public  static StageEntity toEntity(StageDto stageDto){

        if(stageDto == null){
            return null;
        }

        return StageEntity.builder()

                .id(stageDto.getId())
                .nomEntreprise(stageDto.getNomEntreprise())
                .titre(stageDto.getTitre())
                .description(stageDto.getDescription())
                .domaine(stageDto.getDomaine())
                .localisation(stageDto.getLocalisation())
                .dateDebut(stageDto.getDateDebut())
                .dateFin(stageDto.getDateFin())
                .build();
    }

    public  static StageDto toDto(StageEntity stage){

        if(stage == null){
            return null;
        }

        return StageDto.builder()
                .id(stage.getId())
                .nomEntreprise(stage.getNomEntreprise())
                .titre(stage.getTitre())
                .description(stage.getDescription())
                .domaine(stage.getDomaine())
                .localisation(stage.getLocalisation())
                .dateDebut(stage.getDateDebut())
                .dateFin(stage.getDateDebut())
                .build();
    }
}

