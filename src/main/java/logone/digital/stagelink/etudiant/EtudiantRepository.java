package logone.digital.stagelink.etudiant;

import logone.digital.stagelink.entreprise.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository  extends JpaRepository<EtudiantEntity, Long>{

    Optional<EtudiantEntity> findByEmail(String Email);
}
