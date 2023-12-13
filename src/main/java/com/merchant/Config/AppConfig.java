package com.merchant.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    //1.In Memory Authentication
    @Bean
    //UserDetailsService interface in Spring Security used for retrieving user details.
    public UserDetailsService userDetailsService()
    {

        UserDetails user1 = User.builder().username("Rohit").password(passwordEncoder().encode("12345")).roles("ADMIN").build();
        UserDetails user2 = User.builder().username("Admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();

       //Here we pass multiple argument because in InMemoryUserDetailsManager's constructor have where argument
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
