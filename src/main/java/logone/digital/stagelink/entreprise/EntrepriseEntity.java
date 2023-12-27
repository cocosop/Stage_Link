package logone.digital.stagelink.entreprise;
import jakarta.persistence.*;
import logone.digital.stagelink.stage.StageEntity;
import logone.digital.stagelink.user.UserEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_entreprise", indexes = {@Index(name = "index_nom_entreprise", columnList = "nom_entreprise")})
public class EntrepriseEntity extends UserEntity {


    @Column(name = "nom_entreprise")
    private String nomEntreprise;

    @Column
    private String responsable;

    @Column(name = "numméro-de-telephone")
    private String telephone;

    @Column
    private String adresse;

    @Column
    private Instant dateInscription;

    @Column(name = "etat-compte")
    private String statut;

//  @JsonIgnore
//    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<StageEntity> stage  =  new ArrayList<>();

}
