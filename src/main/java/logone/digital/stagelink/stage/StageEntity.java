package logone.digital.stagelink.stage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_stage",  indexes = {@Index(name = "FK_stage", columnList = "titre_stage")})
public class StageEntity implements Serializable {

    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStage;
    @Column(name = "titre_stage")
    private String titreStage;
    @Size(max = 1000000000)
    private String description;
    private String localisation;
    private Instant dateDebut;
    private Instant dateFin;



    @ManyToOne(targetEntity = EntrepriseEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "email", referencedColumnName = "email", foreignKey = @ForeignKey(name = "FK_entreprise"))
    private EntrepriseEntity entreprise;



//    @JsonIgnore
//    @ManyToMany
//    private Set<EtudiantEntity> etudiants;
//
//    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
//    private Set<PostulationEntity> postulation;

}
