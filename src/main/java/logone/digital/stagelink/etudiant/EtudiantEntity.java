package logone.digital.stagelink.etudiant;
import jakarta.persistence.*;
import logone.digital.stagelink.user.UserEntity;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_etudiant")
public class EtudiantEntity extends UserEntity {


        @Column(name = "nom_etudiant")
        private String nom;

        @Column
        private String prenom;

        @Column
        private String competences;

        @Column
        private String interets;

        @Column
        private String parcoursAcademique;

        @Column(name = "numéro-de-telephone")
        private String telephone;

        @Column
        private String adresse;

        @Column
        private Instant dateInscription;

        @Column(name = "etat-compte")
        private String  statut;



        //@JsonIgnore
        //@ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
       // private Set<StageEntity> stage;

        //@JsonIgnore
       // @OneToMany(mappedBy = "etudiant2", cascade = CascadeType.ALL)
       // private Set<PostulationEntity> postulation;




}
