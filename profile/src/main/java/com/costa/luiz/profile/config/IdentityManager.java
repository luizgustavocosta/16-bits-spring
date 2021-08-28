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
public class IdentityManager {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    @Profile("dev")
    UserDetailsService devUsers() {
        var dev = "dev";
        var user = User
            .withUsername(dev)
            .password(passwordEncoder.encode(dev))
            .roles(Roles.USER.name())
            .build();

        var thanos = "thanos";
        var manager = User
            .withUsername(thanos)
            .password(passwordEncoder.encode(thanos))
            .roles(Roles.USER.name(), Roles.MANAGER.name())
            .build();

        return new InMemoryUserDetailsManager(user, manager);
    }

    @Bean
    @Profile({"prod", "cloud", "on-prem", "default"})
    UserDetailsService defaultUsers() {
        var userValue = "user";
        var user = User
            .withUsername(userValue)
            .password(passwordEncoder.encode(userValue))
            .roles(Roles.USER.name())
//            .authorities("USER")
            .build();

        var adminValue = "admin";
        var admin = User
            .withUsername(adminValue)
            .password(passwordEncoder.encode(adminValue))
//            .authorities("USER", "MANAGER")
            .roles(Roles.USER.name(), Roles.MANAGER.name()).build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
