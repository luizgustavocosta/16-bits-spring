package com.costa.luiz.comics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/preview").hasAnyRole(Roles.READER.name(), Roles.WRITER.name())
            .antMatchers("/characters").hasRole(Roles.WRITER.name())
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll().and()
            .logout().permitAll();
    }
}
