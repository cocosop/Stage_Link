package logone.digital.stagelink.postulation;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PostulationDto {

    private Long idPostulation;
    @NotNull(message = "La date de postulation est obligatoire")
    private Instant datePostulation;
    @NotNull(message = "Le statut est obligatoire")
    private String statut;

    public  static PostulationEntity toEntity(PostulationDto postulationDto){

        if(postulationDto == null){
            return null;
        }

        return PostulationEntity.builder()
                .idPostulation(postulationDto.getIdPostulation())
                .datePostulation(postulationDto.getDatePostulation())
                .statut(postulationDto.getStatut())
                .build();
    }

    public  static PostulationDto toDto(PostulationEntity postulation){

        if(postulation == null){
            return null;
        }

        return PostulationDto.builder()
                .idPostulation(postulation.getIdPostulation())
                .datePostulation(postulation.getDatePostulation())
                .statut(postulation.getStatut())
                .build();
    }
}

