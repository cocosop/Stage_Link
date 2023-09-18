package logone.digital.stagelink.etudiant;


import logone.digital.stagelink.entreprise.EntrepriseAlreadyExistsException;
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
public class EtudiantService implements IEtudiantService{

    final EtudiantRepository etudiantRepository;

    /*@Override
    public EtudiantDto create(EtudiantDto etudiant) {
        return EtudiantDto.toDto(
                etudiantRepository.save(EtudiantDto.toEntity(etudiant)));
    }*/

    @Override
    public EtudiantDto create(EtudiantEntity etudiant) {

        Optional<EtudiantEntity> theStudent= etudiantRepository.findByEmail(etudiant.getEmail());
        if (theStudent.isPresent()){
            throw new EtudiantAlreadyExistException("Student with this email already exist");
        }

        return  EtudiantDto.toDto(
                etudiantRepository.save(etudiant));
    }

    @Override
    public List<EtudiantDto> readAll() {
        return etudiantRepository.findAll().stream()
                .map(EtudiantDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EtudiantDto readOneById(Long id) {
        return EtudiantDto.toDto(etudiantRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Etudiant not exist")));
    }

    @Override
    public EtudiantDto update(EtudiantDto etudiant) {
        return EtudiantDto.toDto(
                etudiantRepository.save(EtudiantDto.toEntity(etudiant)));
    }

   /* @Override
    public void deleteOneById(Long id) {
        etudiantRepository.deleteById(id);
    }*/

    @Override
    public String deleteOneById(Long id) {
        if(etudiantRepository.existsById(id)){
            etudiantRepository.deleteById(id);
            return "Delete with success";
        }else {
            throw new NoSuchElementException("No User with that Id");
        }
    }

    @Override
    public void deleteOne(EtudiantDto etudiant) {
        etudiantRepository.delete(EtudiantDto.toEntity(etudiant));
    }

}
