package logone.digital.stagelink.stage;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageDtoRequest {
    private  Long idStage;
    @NotNull(message = "Le titre est obligatoire")
    private String titreStage;
    @NotNull(message = "La description est obligatoire")
    @Size(max = 1000000000)
    private String description;
    @NotNull(message = "La localisation est obligatoire")
    private String localisation;
    @NotNull(message = "Le date de debut est obligatoire")
    private Instant dateDebut;
    @NotNull(message = "Le date de fin est obligatoire")
    private Instant dateFin;
    private String email;

}

