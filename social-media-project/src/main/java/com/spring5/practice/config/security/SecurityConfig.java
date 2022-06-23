package com.spring5.practice.config.security;

import com.spring5.practice.config.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.spring5.practice.config","com.spring5.practice.service"})
public class SecurityConfig {


    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthSuccessHandler authSuccessHandler;

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, AuthSuccessHandler authSuccessHandler) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authSuccessHandler = authSuccessHandler;
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
                        .antMatchers("/", "/user/login","/user/create/","/user/store").permitAll()
                        .antMatchers("/location/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> {
                            try {
                                form
                                        .loginPage("/user/login")
                                        .permitAll()
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .loginProcessingUrl("/login-process")
                                        .successHandler(authSuccessHandler)
                                        .defaultSuccessUrl("/")
                                        .permitAll()
                                        .and()
                                        .logout()
                                        .logoutUrl("/user/logout")
                                        .logoutSuccessUrl("/user/login")
                                        .and()
//                                        .exceptionHandling()
//                                            .accessDeniedPage("/403");
                                        .exceptionHandling()
                                        .accessDeniedHandler(new CustomAccessDeniedHandler());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
        return http.build();
    }
}
