package com.telcobright.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class GatewayConfig {

    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allowed Origins
        List<String> allowedOrigins = Arrays.asList("http://localhost:3000");
        config.setAllowedOrigins(allowedOrigins);

        // Allowed Methods
        List<String> allowedMethods = Arrays.asList("GET", "POST", "PUT", "DELETE");
        config.setAllowedMethods(allowedMethods);

        config.setMaxAge(3600L);
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}