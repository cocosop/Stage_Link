package logone.digital.stagelink.postulation;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PostulationDto {

    private Long id;
    @NotNull(message = "La date de postulation est obligatoire")
    private Instant datePostulation;
    @NotNull(message = "Le statut est obligatoire")
    private Boolean statut;
    @NotNull(message = "Le code est obligatoire")
    private Long code;

    public  static PostulationEntity toEntity(PostulationDto postulationDto){

        if(postulationDto == null){
            return null;
        }

        return PostulationEntity.builder()
                .id(postulationDto.getId())
                .datePostulation(postulationDto.getDatePostulation())
                .statut(postulationDto.getStatut())
                .code(postulationDto.getCode())
                .build();
    }

    public  static PostulationDto toDto(PostulationEntity postulation){

        if(postulation == null){
            return null;
        }

        return PostulationDto.builder()
                .id(postulation.getId())
                .datePostulation(postulation.getDatePostulation())
                .statut(postulation.getStatut())
                .code(postulation.getCode())
                .build();
    }
}

