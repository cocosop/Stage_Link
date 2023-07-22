package logone.digital.stagelink.entreprise;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntrepriseService implements IEntrepriseService{

    final EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto create(EntrepriseDto entreprise) {
        return EntrepriseDto.toDto(
                entrepriseRepository.save(EntrepriseDto.toEntity(entreprise)));
    }

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

    @Override
    public void deleteOneById(Long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public void deleteOne(EntrepriseDto entreprise) {
        entrepriseRepository.delete(EntrepriseDto.toEntity(entreprise));
    }

}


