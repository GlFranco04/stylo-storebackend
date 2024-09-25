package com.stylo.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Aplica CORS a las rutas de la API
            .allowedOrigins("http://localhost:3000")  // Permite el frontend
            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")  // Métodos permitidos
            .allowedHeaders("*")  // Permite todos los headers
            .allowCredentials(true);  // Si usas cookies o autenticación
    }
}
