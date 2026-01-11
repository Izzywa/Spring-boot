package com.REST.spring_boot.security;

import com.REST.spring_boot.authentication.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Marks this class as a configuration class for Spring. Marks as a source of bean definitions
// Spring will call the methods annotated with @Bean
// Register the beans in the application context
@RequiredArgsConstructor // Lombok generates a constructor for all final fields
// this enables constructor injection without writing the constructor yourself
public class ApplicationConfig {
    private final UsersRepository usersRepository; // A final field that Lombok will include in the generated constructor
    // At runtime, Spring injects an instance of UsersRepository into this class

    @Bean
    public UserDetailsService userDetailsService() {
        // use repository to find user by email
        // The returned object must be a UserDetails instance
        // so the Users entity must implement UserDetails, or else DaoAuthenticationProvider will throw an error
        return username -> usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    // register as a bean so Spring can inject it where needed
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config // Spring injects AuthenticationConfiguration
    ) throws Exception {
        // for authentication controller/service that needs to call authenticate() to validate credentials and issue a JWT
        return config.getAuthenticationManager(); // Spring Security produces the configured AuthenticationManager
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt = strong hashing function for passwords
        // DaoAuthenticationProvider needs a PasswordEncoder to compare raw password with stored hashed password
        return new BCryptPasswordEncoder();
    }
}

/*
* All @Bean methods create singleton beans by default
* created once and reused throughout the application
* beans from methods in the same class =
* ensure password encoder and user details service can be injected into other beans automatically
* */