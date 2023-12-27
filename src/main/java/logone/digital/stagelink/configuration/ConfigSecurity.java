package logone.digital.stagelink.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
@Configuration
public class ConfigSecurity {

//    private static final String[] ENT_SECURED_URLs = {
//            "/api/v1/stages/ajouter",
//            "/api/v1/stages/modifier",
//            "/api/v1/stages/supprimer/**",
//            "/api/v1/etudiants/recuperer/**",
//            "/api/v1/entreprises/modifier",
//            "/api/v1/entreprises/supprimer/1",
//            "/api/v1/postulations/modifier",
//            "/api/v1/postulations/recuperer-tous"
//
//    };
//    private static final String[] ETU_SECURED_URLs = {
//
//            "/api/v1/stages/modifier",
//            "/api/v1/stages/recuperer/**",
//            "/api/v1//postulations/ajouter",
//            "/api/v1/postulations/recuperer-tous",
//            "/api/v1/etudiants/modifier",
//            "/api/v1/etudiants/supprimer/**",
//            "/api/v1/etudiants/recuperer/**"
//
//
//    };
//
//    private static final String[] UN_SECURED_URLs = {
//            "/api/v1/stages/recuperer-tous",
//            "/api/v1/etudiants/ajouter",
//            "/api/v1/entreprises/ajouter",
//
//    };

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        return httpSecurity
//                .cors(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests((matchers)-> matchers.requestMatchers(UN_SECURED_URLs).permitAll())
////                .authorizeHttpRequests((matchers)-> matchers.requestMatchers(ENT_SECURED_URLs).hasAuthority("ENTREPRISE"))
////                .authorizeHttpRequests((matchers)-> matchers.requestMatchers(ETU_SECURED_URLs).hasAuthority("ETUDIANT"))
//                .authorizeHttpRequests((authorize)-> authorize.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .logout(LogoutConfigurer::permitAll)
//                .build();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService(){
//        return new SecurityUserDetailsService();
//    }
//
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager
//            (AuthenticationConfiguration config) throws Exception
//    {
//        return config.getAuthenticationManager();
//    }
}
