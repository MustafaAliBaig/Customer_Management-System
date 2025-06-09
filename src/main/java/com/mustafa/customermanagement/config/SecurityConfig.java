package com.mustafa.customermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
               // .csrf(csrf -> csrf.disable())
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for REST API
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                //.httpBasic();
                .httpBasic(Customizer.withDefaults()); // Modern Basic Auth configuration
        return http.build();
    }
}