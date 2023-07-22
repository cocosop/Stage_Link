package logone.digital.stagelink.user;

import java.util.List;

public interface IUserService {

    UserDto create(UserDto user);

    List<UserDto> readAll();

    UserEntity getUser(String email);

    UserDto update(UserDto userDto);

    String deleteOneById(Long id);

}
