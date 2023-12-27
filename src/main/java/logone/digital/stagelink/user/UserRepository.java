package logone.digital.stagelink.user;

import logone.digital.stagelink.entreprise.EntrepriseEntity;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
