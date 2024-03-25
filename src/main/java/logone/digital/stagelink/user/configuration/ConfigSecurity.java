package logone.digital.stagelink.user.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class ConfigSecurity {

    private static final String[] ENT_SECURED_URLs = {
            "/api/v1/stages/ajouter",
            "/api/v1/stages/modifier",
            "/api/v1/stages/supprimer/**",
            "/api/v1/etudiants/recuperer/**",
            "/api/v1/entreprises/modifier",
            "/api/v1/entreprises/supprimer/**",
            "/api/v1/postulations/modifier",
            "/api/v1/postulations/recuperer-tous",
            "/api/v1/entreprises/recuperer-tous"

    };
    private static final String[] ETU_SECURED_URLs = {

            "/api/v1/stages/modifier",
            "/api/v1/stages/recuperer/**",
            "/api/v1/postulations/ajouter",
            "/api/v1/postulations/recuperer-tous",
            "/api/v1/etudiants/modifier",
            "/api/v1/etudiants/supprimer/**",
            "/api/v1/etudiants/recuperer/**",
            "/api/v1/etudiants/recuperer-tous"
    };

    private static final String[] UN_SECURED_URLs = {
//            "/api/v1/stages/recuperer-tous",
//            "/api/v1/etudiants/ajouter",
//            "/api/v1/entreprises/ajouter",
    };

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getDetailsService(){
        return new UserDetailsServices();
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth-> {
             auth.requestMatchers(ENT_SECURED_URLs).hasAuthority("ENTREPRISE");
             auth.requestMatchers(ETU_SECURED_URLs).hasAuthority("ETUDIANT");
             auth.requestMatchers(UN_SECURED_URLs).hasAnyAuthority("ETUDIANT","ENTREPRISE");
            auth.anyRequest().permitAll();
        });
        http.csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic ->httpBasic.disable())
                .cors(cors -> cors.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS));
        return http.build();
    }





}
