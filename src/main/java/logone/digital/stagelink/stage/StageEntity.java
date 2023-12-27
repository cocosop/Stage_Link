package logone.digital.stagelink.stage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.postulation.PostulationEntity;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_stage")
public class StageEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String localisation;
    private Instant dateDebut;
    private Instant dateFin;


    @ManyToOne(targetEntity = EntrepriseEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "nom_entreprise", referencedColumnName = "nom_entreprise", foreignKey = @ForeignKey(name = "FKetbkxhwwtp3ktu4v3oxfwkn9"))
    private EntrepriseEntity entreprise;



//    @JsonIgnore
//    @ManyToMany
//    private Set<EtudiantEntity> etudiants;
//
//    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
//    private Set<PostulationEntity> postulation;

}
