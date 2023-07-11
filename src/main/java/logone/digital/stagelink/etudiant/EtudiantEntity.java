package logone.digital.stagelink.etudiant;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.postulation.PostulationEntity;
import logone.digital.stagelink.stage.StageEntity;
import logone.digital.stagelink.utilisateur.UtilisateurEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_stage")
@Builder
public class EtudiantEntity extends UtilisateurEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String prenom;

    @Column
    private String matricule;

    @Column
    private  String competences;

    @Column
    private String interet;

    @Column
    private String parcoursAcadémique;


    @JsonIgnore
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<PostulationEntity> postulant0;

    @JsonIgnore
    @ManyToMany
    private Set<StageEntity> stage0;

}

