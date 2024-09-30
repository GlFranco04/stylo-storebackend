package com.stylo.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Aplica CORS a las rutas de la API
        .allowedOrigins("*") // Permite todos los orígenes
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // Métodos permitidos
        .allowedHeaders("*") // Permite todos los headers
        .allowCredentials(false); // No permite credenciales cuando se usan todos los orígenes
    }
}
