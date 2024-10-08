package dev.nassime.restaurant1.api.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private JWTRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Désactiver CSRF
        http.csrf(AbstractHttpConfigurer::disable);
        // Désactiver la gestion du CORS si nécessaire
        http.cors(AbstractHttpConfigurer::disable);

        // Ajouter le filtre JWT avant le filtre d'autorisation
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);

        // Autoriser des URL spécifiques sans authentification
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/client/add", "/client/login", "/client/actual").permitAll()  // Autoriser l'accès sans authentification
                .anyRequest().authenticated()  // Toute autre requête doit être authentifiée
        );
        return http.build();  // Construire la chaîne de filtres de sécurité



    }
}
