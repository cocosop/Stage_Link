package logone.digital.stagelink.etudiant;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_etudiant")
@Builder
public class EtudiantEntity {


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



}
