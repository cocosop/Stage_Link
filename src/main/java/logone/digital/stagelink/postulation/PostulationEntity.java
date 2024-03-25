package logone.digital.stagelink.postulation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import logone.digital.stagelink.etudiant.EtudiantEntity;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.etudiant.EtudiantEntity;

import logone.digital.stagelink.stage.StageEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_postulation")
public class PostulationEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulation;
    private Instant datePostulation;
    private String statut;

    @ManyToOne(targetEntity = EtudiantEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "email", referencedColumnName = "email", foreignKey =
    @ForeignKey(name = "FK_etudiant"))
    private EtudiantEntity etudiant;

    @ManyToOne(targetEntity = StageEntity.class, fetch = FetchType.LAZY )
    @JoinColumn(name = "idStage", referencedColumnName = "idStage", foreignKey =
    @ForeignKey(name = "FK_stage"))
    private StageEntity stage;


}
