package com.pfc.revisiones.app.inventario.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filtertChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((authz) -> authz
        .requestMatchers(HttpMethod.GET,"/api/equipos").permitAll()
        .requestMatchers(HttpMethod.GET,"/api/equipos/{id}").permitAll()
        .requestMatchers(HttpMethod.GET,"/api/usuarios").permitAll()
        .requestMatchers(HttpMethod.POST,"/api/usuarios/registro").permitAll()
        .requestMatchers(HttpMethod.POST,"/api/equipos").permitAll()
        .requestMatchers(HttpMethod.GET,"/v1/qrcode").permitAll()
        .requestMatchers(HttpMethod.DELETE,"/api/equipos/{id}").permitAll()
        .requestMatchers(HttpMethod.PUT,"/api/equipos/{id}").permitAll()
        .anyRequest().authenticated())
        .csrf(config -> config.disable())
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }

}
