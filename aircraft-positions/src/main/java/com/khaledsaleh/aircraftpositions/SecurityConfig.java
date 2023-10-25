package com.khaledsaleh.aircraftpositions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    private final PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    UserDetailsService authentication(){
        UserDetails khaled = User.builder()
                .username("khaled")
                .password(pwEncoder.encode("kpassword"))
                .roles("ADMIN", "USER")
                .build();
        UserDetails saleh = User.builder()
                .username("saleh")
                .password(pwEncoder.encode("spassword"))
                .roles("USER")
                .build();
        System.out.println("    >>> Khaled's password: " + khaled.getPassword());
        System.out.println("    >>> Saleh's password: " + saleh.getPassword());
        return new InMemoryUserDetailsManager(khaled, saleh);
    }
}
