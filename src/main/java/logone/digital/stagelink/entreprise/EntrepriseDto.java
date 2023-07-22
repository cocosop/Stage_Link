package logone.digital.stagelink.entreprise;


import logone.digital.stagelink.entreprise.EntrepriseDto;
import logone.digital.stagelink.entreprise.EntrepriseEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

    private Long id;
    private String responsable;

    public static EntrepriseEntity toEntity(EntrepriseDto entreprise) {

        if (entreprise == null) {
            return null;
        }

        return EntrepriseEntity.builder()
                .id(entreprise.id)
                .responsable(entreprise.responsable)
                .build();
    }
    public  static EntrepriseDto toDto(EntrepriseEntity entreprise) {

        if (entreprise == null) {
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .responsable(entreprise.getResponsable())
                .build();

    }

}


