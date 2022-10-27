package com.dev.springbootmicroservice1realstate.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;
    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;
    @Value("${service.security.secure-key-username-2}")
    private String SECURE_KEY_USERNAME_2;
    @Value("${service.security.secure-key-password-2}")
    private String SECURE_KEY_PASSWORD_2;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder managerBuilder = httpSecurity.getSharedObject(
            AuthenticationManagerBuilder.class);//capture the request from client, and check credentials in header request
        //log.info("Capture the request at Builder: {}", managerBuilder.getObject());
        managerBuilder.inMemoryAuthentication()
            .withUser(SECURE_KEY_USERNAME)
            .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
            .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
            .and()
            .withUser(SECURE_KEY_USERNAME_2)
            .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_2))
            .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
            .and()
            .passwordEncoder(new BCryptPasswordEncoder());

        return httpSecurity
            .antMatcher("/**")
            .authorizeRequests()
            .anyRequest()
            .hasRole("ADMIN")
            .and()
            .csrf()
            .disable()
            .httpBasic()
            /*.and()
            .exceptionHandling()
            .accessDeniedHandler((request, response, accessDeniedException) -> {
                response.sendRedirect("https://vaxidrez.com");
            })*/ //session not support by the moment
            .and()
            .build();
    }
}
