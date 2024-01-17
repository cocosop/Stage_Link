package logone.digital.stagelink.etudiant;
import jakarta.persistence.*;
import logone.digital.stagelink.user.User;
import lombok.*;
import java.time.Instant;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_etudiant", indexes = {@Index(name = "index_nom_etudiant", columnList = "nomEtudiant")})
public class EtudiantEntity extends User {


        @Column(name = "nomEtudiant")
        private String nomEtudiant;

        @Column
        private String prenomEtudiant;

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
        private String cv;

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
