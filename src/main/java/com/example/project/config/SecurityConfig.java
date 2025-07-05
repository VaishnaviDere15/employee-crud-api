package com.example.project.config;

import com.example.project.auth.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
                .ignoringAntMatchers("/h2-console/**") // ✅ allow H2 console
            .and()
            .authorizeRequests()
            .antMatchers(
                   
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/swagger-resources/**",
                    "/webjars/**",
                    
                   
                    "/view/employees/login",
                    "/css/**",
                    "/js/**",
                    "/h2-console/**"
                ).permitAll()
                .antMatchers("/view/employees/login", "/css/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/view/employees/add", "/view/employees/edit/**", "/view/employees/delete/**").hasRole("ADMIN")
                .antMatchers("/view/employees/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/employees/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/view/employees/login")
                .defaultSuccessUrl("/view/employees", true)
                .loginProcessingUrl("/login")
                .failureUrl("/view/employees/login?error=true")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/view/employees/login?logout=true")
                .permitAll()
            .and()
            .headers()
                .frameOptions().sameOrigin(); // ✅ required for H2 console to work

        return http.build();
    }
}
