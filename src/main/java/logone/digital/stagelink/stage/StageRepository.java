package logone.digital.stagelink.stage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StageRepository extends JpaRepository<StageEntity, Long> {
    Optional<Object> findByDomaine(String domaine);
}
