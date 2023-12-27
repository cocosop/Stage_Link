package logone.digital.stagelink.entreprise;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseModel {
    @Column(name = "nom_entreprise")
    String nomEntreprise;
}
