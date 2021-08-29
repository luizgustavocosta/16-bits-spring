package com.costa.luiz.comics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
        var dc = "tomking";

        return new InMemoryUserDetailsManager(
            createUserUsing(dev, dev, Roles.READER.name()),
            createUserUsing(dc, dc, Roles.READER.name(), Roles.WRITER.name()));
    }

    @Bean
    @Profile({"marvel", "default"})
    UserDetailsService defaultUsers() {
        var userValue = "user";
        var adminValue = "admin";
        var writer = "stanLee";

        return new InMemoryUserDetailsManager(
            createUserUsing(userValue, userValue, Roles.READER.name()),
            createUserUsing(adminValue, adminValue, Roles.READER.name(), Roles.WRITER.name()),
            createUserUsing(writer, writer, Roles.READER.name(), Roles.WRITER.name()));
    }

    private UserDetails createUserUsing(String name, String password, String... roles) {
        return User
            .withUsername(name)
            .password(passwordEncoder.encode(password))
            .roles(roles)
            .build();
    }
}
