package logone.digital.stagelink.postulation;


import logone.digital.stagelink.entreprise.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulationRepository extends JpaRepository<PostulationEntity,Long> {
    Optional<PostulationEntity> findByCode(Long Code);
}

