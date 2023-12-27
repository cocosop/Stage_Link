package logone.digital.stagelink.etudiant;

import jakarta.transaction.Transactional;
import logone.digital.stagelink.entreprise.EntrepriseAlreadyExistsException;
import logone.digital.stagelink.entreprise.EntrepriseDtoResponse;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService{

    final EtudiantRepository etudiantRepository;
    final PasswordEncoder passwordEncoder;
    final EtudiantMapper etudiantMapper;
    public String generateRole(){
        String role = "ETUDIANT";
        return  role;
    }

    public Instant generateDate(){
        Instant today = Instant.now();
        return  today;
    }
    @Override
    public EtudiantDtoResponse create(EtudiantDtoRequest etudiant) {
        Optional<EtudiantEntity> etudiantEntity = this.etudiantRepository.findByEmail(etudiant.getEmail());
        etudiant.setMotDePasse(this.passwordEncoder.encode(etudiant.getMotDePasse()));
        etudiant.setRoles(this.generateRole());
        etudiant.setDateInscription(this.generateDate());

        EtudiantEntity etudiant1 = this.etudiantMapper.etudiantDtoVersEtudiant(etudiant);
        if (etudiantEntity.isPresent()){
            throw new EtudiantAlreadyExistException("Student with this email already exist !!!");
        }

        return this.etudiantMapper.etudiantVersEtudiantDto(this.etudiantRepository.save(etudiant1));
    }

    @Override
    public List<EtudiantDtoResponse> readAll() {
        List<EtudiantEntity> etudiant = (List<EtudiantEntity>) this.etudiantRepository.findAll();
        List<EtudiantDtoResponse> etudiantResponse = new ArrayList<>();
        etudiant.forEach(etudiant1 -> etudiantResponse.add(this.etudiantMapper.etudiantVersEtudiantDto(etudiant1)));
        return etudiantResponse;
    }

    @Override
    public EtudiantDtoResponse readOneByEmail(String email) {
        try {
            return this.etudiantMapper.etudiantVersEtudiantDto(this.etudiantRepository.findByEmail(email).get());
        }catch (Exception ex){
            throw new EtudiantAlreadyExistException("This email " +email+ " doesn't exist in our data base");
        }
    }

    @Override
    public EtudiantDtoResponse update(EtudiantDtoRequest etudiant, String email) throws EtudiantAlreadyExistException {
        try {
            // Recherche l'entité par email
            EtudiantEntity etudiantEntity = this.etudiantRepository.findByEmail(email)
                    .orElseThrow(() -> new Error("Student with this email " + email + " doesn't exist in our data base"));

            // Mappe la requête sur l'entité
            EtudiantEntity etudiant1 = this.etudiantMapper.etudiantDtoVersEtudiant(etudiant);
            // Conserve l'id, les rôles et le statut de l'entité originale
            etudiant1.setId(etudiantEntity.getId());
            etudiant1.setRoles(etudiantEntity.getRoles());
            etudiant1.setStatut(etudiantEntity.getStatut());
            // Sauvegarde l'entité modifiée
            return this.etudiantMapper.etudiantVersEtudiantDto(this.etudiantRepository.save(etudiant1));
        } catch (EtudiantAlreadyExistException e) {
            // Relance les exceptions personnalisées
            throw e;
        } catch (Exception e) {
            // Traite les autres exceptions
            e.printStackTrace();
            // Retourne null ou une réponse par défaut
            return null;
        }
    }

    @Transactional
    @Override
    public void deleteOne(String email) {
        Optional<EtudiantEntity> etudiantEntity = this.etudiantRepository.findByEmail(email);
        if (etudiantEntity.isEmpty()){
            throw new EtudiantAlreadyExistException("This email " +email+ " doesn't exist in our data base");
        }
        this.etudiantRepository.deleteByEmail(email);
    }
}
