package logone.digital.stagelink.etudiant;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantModel {
    @Column(name = "email")
    String email;

    @Column(name = "cv")
    String cv;

    @Column(name = "photo")
    String photo;


}
