package logone.digital.stagelink.stage;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageDtoRequest {
    private  Long id;
    @NotNull(message = "Le titre est obligatoire")
    private String titre;
    @NotNull(message = "La description est obligatoire")
    private String description;
    @NotNull(message = "La localisation est obligatoire")
    private String localisation;
    @NotNull(message = "Le date de debut est obligatoire")
    private Instant dateDebut;
    @NotNull(message = "Le date de fin est obligatoire")
    private Instant dateFin;
    @NotNull(message = "Le nom de l'entreprise est obligatoire")
    private String nomEntreprise;

}

