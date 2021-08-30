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
            .antMatchers("/").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers("/comics/preview").hasAnyRole(Roles.READER.name(), Roles.WRITER.name())
            .antMatchers("/comics/stories/characters").hasRole(Roles.WRITER.name())
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .logout().permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.exceptionHandling().accessDeniedHandler(ComicAccessDeniedHandler.INSTANCE);
    }
}
