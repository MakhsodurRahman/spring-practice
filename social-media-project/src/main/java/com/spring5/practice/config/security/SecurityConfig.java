package com.spring5.practice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.spring5.practice.config","com.spring5.practice.service"})
public class SecurityConfig {


    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .antMatchers("/resources/**", "/temp/**").permitAll()
                        .antMatchers("/", "/login").permitAll()
                        .antMatchers(("/location/**")).hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> {
                            try {
                                form
                                        .loginPage("/login")
                                        .permitAll()
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .loginProcessingUrl("/login-process")
                                        .defaultSuccessUrl("/")
                                        .permitAll()
                                        .and()
                                        .exceptionHandling()
                                            .accessDeniedPage("/403");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
        return http.build();
    }
}
