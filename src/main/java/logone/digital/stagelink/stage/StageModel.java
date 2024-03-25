package logone.digital.stagelink.stage;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import logone.digital.stagelink.entreprise.EntrepriseModel;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageModel {
    @Column(name = "idStage")
    String idStage;
    @Column(name = "titreStage")
    private String titreStage;
    private EntrepriseModel entreprise;


}
