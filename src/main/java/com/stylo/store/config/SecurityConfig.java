package com.stylo.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Deshabilita CSRF para evitar problemas con solicitudes POST
            .authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()  // Permitir acceso a todas las rutas sin autenticación
            );
        return http.build();
    }
}
