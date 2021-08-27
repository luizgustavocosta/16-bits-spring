package com.costa.luiz.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUser {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Profile("dev")
    UserDetailsService devUsers() {
        var user = User
            .withUsername("guga")
            .password(passwordEncoder.encode("guga"))
            .roles("USER")
            .build();

        var admin = User
            .withUsername("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("USER", "MANAGER").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    @Profile({"prod", "default"})
    UserDetailsService defaultUsers() {
        var user = User
            .withUsername("user")
            .password(passwordEncoder.encode("user"))
            .roles("USER")
            .build();

        var admin = User
            .withUsername("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("USER", "MANAGER").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
