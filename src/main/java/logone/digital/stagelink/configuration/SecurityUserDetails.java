//package logone.digital.stagelink.configuration;
//
//
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Data
//@Slf4j
//public class SecurityUserDetails implements UserDetails {
//    private final String email;
//    private final String password;
//    private final List<GrantedAuthority> authorities;
//
////    public SecurityUserDetails (UserEntity user){
////        email = user.getEmail();
////        password = user.getMotDePasse();
////        //
////        authorities = Arrays.stream(user.getRoles().split(","))
////                .map(SimpleGrantedAuthority::new)
////                .collect(Collectors.toList());
////    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//}
