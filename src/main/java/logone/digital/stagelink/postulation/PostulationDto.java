package logone.digital.stagelink.postulation;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PostulationDto {

    private Long id;
    private Instant datePostulation;
    private Boolean statut;

    public  static PostulationEntity toEntity(PostulationDto postulation){

        if(postulation == null){
            return null;
        }

        return PostulationEntity.builder()
                .id(postulation.id)
                .datePostulation(postulation.datePostulation)
                .statut(postulation.statut)
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
                .build();
    }
}

