package logone.digital.stagelink.postulation;


import jakarta.validation.constraints.NotNull;
import logone.digital.stagelink.etudiant.EtudiantModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostulationDtoRequest{

    private Long idPostulation;
    private Instant datePostulation;
    private String statut;
    private  Long idStage;
    private String email;



}

