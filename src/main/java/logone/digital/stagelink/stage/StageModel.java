package logone.digital.stagelink.stage;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageModel {
    @Column(name = "titre_stage")
    String titreStage;
}
