package logone.digital.stagelink.entreprise;

import jakarta.transaction.Transactional;
import logone.digital.stagelink.etudiant.EtudiantAlreadyExistException;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import logone.digital.stagelink.stage.StageEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrepriseService implements IEntrepriseService{
    final EntrepriseRepository entrepriseRepository;
    final EntrepriseMapper entrepriseMapper;
    final PasswordEncoder passwordEncoder;

    public String generateRole(){
        String role = "ENTREPRISE";
        return  role;
    }
    public String generateStatut(){
        String statut = "Actif";
        return  statut;
    }
    public Instant generateDate(){
        Instant today = Instant.now();
        return  today;
    }

    @Override
    public EntrepriseDtoResponse create(EntrepriseDtoRequest entreprise) {
        Optional<EntrepriseEntity> entrepriseEntity = this.entrepriseRepository.findByEmail(entreprise.getEmail());
        entreprise.setPassword(this.passwordEncoder.encode(entreprise.getPassword()));
        entreprise.setRoles(this.generateRole());
        entreprise.setStatut(this.generateStatut());
        entreprise.setDateInscription(this.generateDate());
        EntrepriseEntity entreprise1 = this.entrepriseMapper.entrepriseDtoVersEntreprise(entreprise);
        if (entrepriseEntity.isPresent()){
            throw new EntrepriseAlreadyExistsException("Entreprise with this email already exist !!!");
        }
        return this.entrepriseMapper.entrepriseVersEntrepriseDto(this.entrepriseRepository.save(entreprise1));
    }

    @Override
    public List<EntrepriseDtoResponse> readAll() {
        List<EntrepriseEntity> entreprise = (List<EntrepriseEntity>) this.entrepriseRepository.findAll();
        List<EntrepriseDtoResponse> entrepriseResponse = new ArrayList<>();
        entreprise.forEach(entreprise1 -> entrepriseResponse.add(this.entrepriseMapper.entrepriseVersEntrepriseDto(entreprise1)));
        return entrepriseResponse; }

    @Override
    public EntrepriseDtoResponse readOneByEmail(String email) {
        try {
            return this.entrepriseMapper.entrepriseVersEntrepriseDto(this.entrepriseRepository.findByEmail(email).get());
        }catch (Exception ex){
            throw new EntrepriseAlreadyExistsException("This email " +email+ " doesn't exist in our data base");
        }
    }

    @Override
    public EntrepriseDtoResponse update(EntrepriseDtoRequest entreprise, String email) throws EntrepriseAlreadyExistsException {
        try {
            // Recherche l'entité par email
            EntrepriseEntity entrepriseEntity = this.entrepriseRepository.findByEmail(email)
                    .orElseThrow(() -> new Error ("This email " + email + " doesn't exist in our data base"));
            // Mappe la requête sur l'entité
            EntrepriseEntity entreprise1 = this.entrepriseMapper.entrepriseDtoVersEntreprise(entreprise);
            // Conserve l'id, les rôles, la date d'inscription et le statut de l'entité originale
            entreprise1.setDateInscription(entrepriseEntity.getDateInscription());
            entreprise1.setId(entrepriseEntity.getId());
            entreprise1.setRoles(entrepriseEntity.getRoles());
            entreprise1.setStatut(entrepriseEntity.getStatut());
            // Sauvegarde l'entité modifiée
            return this.entrepriseMapper.entrepriseVersEntrepriseDto(this.entrepriseRepository.save(entreprise1));
        } catch (EntrepriseAlreadyExistsException e) {
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
        Optional<EntrepriseEntity> entrepriseEntity = this.entrepriseRepository.findByEmail(email);
        if (entrepriseEntity.isEmpty()){
            throw new EntrepriseAlreadyExistsException("This email " +email+ " doesn't exist in our data base");
        }
        this.entrepriseRepository.deleteByEmail(email);
    }
}


