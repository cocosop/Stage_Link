package logone.digital.stagelink.etudiant;

import logone.digital.stagelink.entreprise.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EtudiantRepository  extends JpaRepository<EtudiantEntity, Long>{

    Optional<EtudiantEntity> findByEmail(String email);

    void  deleteByEmail(String email);
}
