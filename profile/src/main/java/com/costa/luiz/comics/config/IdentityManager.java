package com.costa.luiz.comics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class IdentityManager {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Profile({"dc", "dev"})
    UserDetailsService devUsers() {
        var dev = "dev";
        var user = User
            .withUsername(dev)
            .password(passwordEncoder.encode(dev))
            .roles(Roles.READER.name())
            .build();

        var thanosValue = "thanos";
        var thanos = User
            .withUsername(thanosValue)
            .password(passwordEncoder.encode(thanosValue))
            .roles(Roles.READER.name(), Roles.WRITER.name())
            .build();

        return new InMemoryUserDetailsManager(user, thanos);
    }

    @Bean
    @Profile({"marvel", "default"})
    UserDetailsService defaultUsers() {
        var userValue = "user";
        var user = User
            .withUsername(userValue)
            .password(passwordEncoder.encode(userValue))
            .roles(Roles.READER.name())
            .build();

        var adminValue = "admin";
        var admin = User
            .withUsername(adminValue).password(passwordEncoder.encode(adminValue))
            .roles(Roles.READER.name(), Roles.WRITER.name()).build();

        var stanLeeValue = "stanLee";
        var stanLee = User
            .withUsername(stanLeeValue).password(passwordEncoder.encode(stanLeeValue))
            .roles(Roles.WRITER.name()).build();

        return new InMemoryUserDetailsManager(user, admin, stanLee);
    }
}
