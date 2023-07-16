package logone.digital.stagelink.stage;

import jakarta.persistence.*;
import logone.digital.stagelink.postulation.PostulationEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_stage")
@Builder
public class StageEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titre;

    @Column
    private String description;

    @Column
    private String entreprise;

    @Column
    private String domaine;

    @Column
    private String localisation;

    @Column
    private Instant dateDebut;

    @Column
    private Instant dateFin;



    @ManyToOne
    @JoinColumn(name = "postulation_id")
    private PostulationEntity postulant;

    /*@ManyToOne
    @JoinColumn(name = "entreprise_id")
    private EntrepriseEntity entreprise;*/

    /*@ManyToMany
    private Etudiant etudiant;*/

}
