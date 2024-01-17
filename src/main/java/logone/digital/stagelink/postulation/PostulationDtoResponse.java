package logone.digital.stagelink.postulation;

import logone.digital.stagelink.entreprise.EntrepriseModel;
import logone.digital.stagelink.etudiant.EtudiantModel;
import logone.digital.stagelink.stage.StageModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostulationDtoResponse {
    private Long idPostulation;
    private Instant datePostulation;
    private String statut;
    private StageModel stage;
    private EtudiantModel etudiant;
}
