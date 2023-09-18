package logone.digital.stagelink.entreprise;

import logone.digital.stagelink.user.UserDto;
import logone.digital.stagelink.user.UserEntity;
import logone.digital.stagelink.user.UserExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntrepriseService implements IEntrepriseService{

    final EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto create(EntrepriseEntity entreprise) {

        Optional<EntrepriseEntity> theEntreprise = entrepriseRepository.findByEmail(entreprise.getEmail());
        if (theEntreprise.isPresent()){
            throw new EntrepriseAlreadyExistsException("Entreprise with this email already exist");
        }

        return  EntrepriseDto.toDto(
                entrepriseRepository.save(entreprise));

    }

       /* EntrepriseEntity existingEntreprise
                = entrepriseRepository.findByEmail(entreprise.getEmail())
                .orElse(null);
        if (existingEntreprise == null) {
            EntrepriseEntity savedEntreprise = entrepriseRepository.save(entreprise);
          return EntrepriseDto.toDto(savedEntreprise);
        }
        else
            throw new EntrepriseAlreadyExistsException(
                    "Customer already exists!!");*/




    @Override
    public List<EntrepriseDto> readAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto readOneById(Long id) {
        return EntrepriseDto.toDto(entrepriseRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Entreprise not exist")));
    }

    @Override
    public EntrepriseDto update(EntrepriseDto entreprise) {
        return EntrepriseDto.toDto(
                entrepriseRepository.save(EntrepriseDto.toEntity(entreprise)));
    }

   // @Override
    //public void deleteOneById(Long id) {
        //entrepriseRepository.deleteById(id);    }

    @Override
    public void deleteOne(EntrepriseDto entreprise) {
        entrepriseRepository.delete(EntrepriseDto.toEntity(entreprise));
    }

    @Override
    public String deleteOneById(Long id) {
        if(entrepriseRepository.existsById(id)){
            entrepriseRepository.deleteById(id);
            return "Delete with success";
        }else {
            throw new NoSuchElementException("No User with that Id");
        }
    }
}


