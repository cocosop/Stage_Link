package logone.digital.stagelink.entreprise;
import jakarta.persistence.*;
import logone.digital.stagelink.user.User;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_entreprise", indexes = {@Index(name = "index_nom_entreprise", columnList = "nom_entreprise")})
public class EntrepriseEntity extends User {


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
