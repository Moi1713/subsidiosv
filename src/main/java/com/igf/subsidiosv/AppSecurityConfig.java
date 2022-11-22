package com.igf.subsidiosv;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain configure(final HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/resources/**", "/assets/**").permitAll()
                //.antMatchers("/").hasRole("ADMIN")
                .antMatchers("/solicitudes/**").hasRole("VENDEDOR")
                //.antMatchers("/beneficiarios/**").hasRole("Tecnico")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/index", true)
                .loginPage("/login")
                .and()
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .sessionManagement(session -> session.invalidSessionUrl("/logout"))
                .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true))
                .build();
    }

}
