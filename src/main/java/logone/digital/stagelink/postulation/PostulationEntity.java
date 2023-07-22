package logone.digital.stagelink.postulation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import logone.digital.stagelink.etudiant.EtudiantEntity;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import logone.digital.stagelink.stage.StageEntity;
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
@Table(name = "_postulation")
@Builder
public class PostulationEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Instant datePostulation;

    @Column
    private Boolean statut;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private EtudiantEntity etudiant;

    @JsonIgnore
    @OneToMany(mappedBy = "postulation")
    private Set<StageEntity> stage;



}
