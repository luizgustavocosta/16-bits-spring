package com.costa.luiz.profile.config;

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
            .antMatchers("/hello").hasAnyRole(Roles.MANAGER.name(), Roles.USER.name())
            .antMatchers("/squads").hasRole(Roles.MANAGER.name())
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll().and()
            .logout().permitAll();
    }
}
