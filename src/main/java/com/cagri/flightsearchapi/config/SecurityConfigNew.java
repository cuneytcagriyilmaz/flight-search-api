package com.cagri.flightsearchapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfigNew {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/airports").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/airports/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/airports").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/airports/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/airports/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/flights").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/flights/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/flights").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/flights/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/flights/**").hasRole("ADMIN")


        );
        http.httpBasic(Customizer.withDefaults());


        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();

    }




    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}test123")
                .roles("USER")
                .build();
        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}test123")
                .roles("USER", "MANAGER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}test123")
                .roles("USER", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, manager, admin);
    }




}