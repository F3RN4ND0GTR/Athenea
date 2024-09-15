/**
 * 
 */
package com.fear.athenea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Configuración del SecurityFilterChain, que gestiona las reglas de acceso
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilitar CSRF en una API stateless (sin sesiones)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/athenea/login").permitAll() // Permitir el acceso público al login
                .anyRequest().authenticated()  // Proteger el resto de las rutas
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No utilizar sesiones (stateless)
            );

        return http.build();
    }

    // Bean para gestionar las contraseñas utilizando BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración del AuthenticationManager que gestiona la autenticación de usuarios
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(inMemoryUserDetailsService(passwordEncoder)) // Utilizando un servicio de usuarios en memoria
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    // Servicio de usuarios en memoria para la autenticación
    @Bean
    public UserDetailsService inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Definir un usuario en memoria (puedes cambiarlo para usar una base de datos)
        manager.createUser(
            User.withUsername("user")
                .password(passwordEncoder.encode("password"))  // Encriptar la contraseña
                .roles("USER")
                .build()
        );

        return manager;
    }
}
