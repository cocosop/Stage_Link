package logone.digital.stagelink.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureRoleRepository extends JpaRepository<SecureRole, Long> {
    public SecureRole findByRolename(String role);
}
