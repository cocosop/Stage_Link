package logone.digital.stagelink.entreprise;

import logone.digital.stagelink.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<EntrepriseEntity, Long> {

    Optional<EntrepriseEntity> findByEmail(String Email);
}
