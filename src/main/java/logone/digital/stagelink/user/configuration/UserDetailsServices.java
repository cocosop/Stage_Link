package logone.digital.stagelink.user.configuration;

import logone.digital.stagelink.user.User;
import logone.digital.stagelink.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        System.out.println("username" + user);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }else{
            return new UserDetail(user);
        }



    }

}




