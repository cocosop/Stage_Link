package logone.digital.stagelink.stage;

import logone.digital.stagelink.entreprise.EntrepriseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StageDtoResponse {
    private  Long idStage;
    private String titreStage;
    private String description;
    private String localisation;
    private Instant dateDebut;
    private Instant dateFin;
    private EntrepriseModel entreprise;

}
