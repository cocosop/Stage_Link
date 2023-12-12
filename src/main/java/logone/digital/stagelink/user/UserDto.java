package logone.digital.stagelink.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserDto {

    private Long id;

    @NotNull(message = "Le nom est obligatoire")
    private String nom;

    @NotNull(message = "Le prénom est obligatoire")
    private String telephone;

    @Email(message = "L'adresse email n'est pas valide")
    private String email;

    @NotNull(message = "L' adresse est obligatoire")
    private String adresse;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String motDePasse;
    private Instant dateInscription;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean active;
    private String roles;

    public static UserDto toDto(UserEntity user){

        if( user == null){
            // TODO Throw an exception
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .telephone(user.getTelephone())
                .email(user.getEmail())
                .adresse(user.getAdresse())
                .motDePasse(user.getMotDePasse())
                .dateInscription(user.getDateInscription())

                .roles(user.getRoles())
                .build();
    }


    // mapping: faire correspondre UserDto vers User
    public static UserEntity toEntity(UserDto userDto){

        if( userDto == null){
            // TODO Throw an exception
            return null;
        }

        return UserEntity.builder()
                .id(userDto.getId())
                .nom(userDto.getNom())
                .telephone(userDto.getTelephone())
                .email(userDto.getEmail())
                .adresse(userDto.getAdresse())
                .motDePasse(userDto.getMotDePasse())
                .dateInscription(userDto.getDateInscription())

                .roles(userDto.getRoles())
                .build();
    }


}
