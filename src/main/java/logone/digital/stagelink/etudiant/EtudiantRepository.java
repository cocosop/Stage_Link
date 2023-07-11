package logone.digital.stagelink.etudiant;

import logone.digital.stagelink.etudiant.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<EtudiantEntity,Long> {
}