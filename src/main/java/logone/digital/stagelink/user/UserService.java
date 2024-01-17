package logone.digital.stagelink.user;

import logone.digital.stagelink.entreprise.EntrepriseAlreadyExistsException;
import logone.digital.stagelink.etudiant.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    final UserRepository userRepository;
    public User readOneByEmail(String email) {
        try {
            return this.userRepository.findByEmail(email);
        }catch (Exception ex){
            throw new EntrepriseAlreadyExistsException("This email " +email+ " doesn't exist in our data base");
        }
    }





}