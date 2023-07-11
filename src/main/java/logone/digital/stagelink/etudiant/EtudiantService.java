package logone.digital.stagelink.etudiant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtudiantService {

    final EtudiantRepository etudiantRepository;


    public EtudiantDto create(EtudiantDto etudiant) {
        return EtudiantDto.toDto(
                etudiantRepository.save(EtudiantDto.toEntity(etudiant)));
    }


    public List<EtudiantDto> readAll() {
        return etudiantRepository.findAll().stream()
                .map(EtudiantDto::toDto)
                .collect(Collectors.toList());
    }


    public EtudiantDto readOneById(Long id) {
        return EtudiantDto.toDto(etudiantRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Etudiant not exist")));
    }


    public EtudiantDto update(EtudiantDto etudiant) {
        return EtudiantDto.toDto(
                etudiantRepository.save(EtudiantDto.toEntity(etudiant)));
    }


    public void deleteOneById(Long id) {
        etudiantRepository.deleteById(id);
    }


    public void deleteOne(EtudiantDto etudiant) {
        etudiantRepository.delete(EtudiantDto.toEntity(etudiant));
    }

}
