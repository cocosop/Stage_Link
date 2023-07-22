package logone.digital.stagelink.user;


import logone.digital.stagelink.entreprise.EntrepriseDto;
import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService{


    final UserRepository userRepository;


    @Override
    public UserDto create(UserDto user) {
        Optional<UserEntity> theUser= userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserExistException("User with this email already exist");
        }

        return  UserDto.toDto(
                userRepository.save(UserDto.toEntity(user)));
    }

    @Override
    public List<UserDto> readAll() {

        return userRepository.findAll().stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }


    @Override
    public UserDto update(UserDto user) {
        return UserDto.toDto(
                userRepository.save(UserDto.toEntity(user)));
    }

    @Override
    public String deleteOneById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Delete with success";
        }else {
            throw new NoSuchElementException("No User with that Id");
        }
    }
}
