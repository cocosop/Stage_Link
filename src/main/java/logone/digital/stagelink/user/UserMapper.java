package logone.digital.stagelink.user;

import logone.digital.stagelink.etudiant.EtudiantDtoRequest;
import logone.digital.stagelink.etudiant.EtudiantDtoResponse;
import logone.digital.stagelink.etudiant.EtudiantEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDtoResponse userVersUserDto(User user);
    User userDtoVersUser(UserDtoRequest userDto);
}
