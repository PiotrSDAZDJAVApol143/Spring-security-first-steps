package com.example.sercurityworkshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity (securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig  {
 // @Bean
 // SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
 // httpSecurity.csrf(AbstractHttpConfigurer::disable)
 //         .authorizeHttpRequests(autz ->
 //                 autz
 //                      .requestMatchers("hello/helloAdmin/**").hasRole("ADMIN")
 //                       .requestMatchers(HttpMethod.DELETE).hasRole("Admin")
 //                     .requestMatchers("hello/helloUser/**").hasRole("USER")
 //                         .requestMatchers("hello/forAll").permitAll()
 //                         .requestMatchers("api/login").permitAll()
 //                         .requestMatchers("/dummyV2/**").hasAnyRole("ADMIN"))

 //         .httpBasic(Customizer.withDefaults());
 //     return httpSecurity.build();
 // }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder()
                .username("Piotr")
                .password(passwordEncoder().encode("pass1") )
                .roles("USER", "ADMIN")
                .build();
        UserDetails user2 = User.builder()
                .username("Monika")
                .password(passwordEncoder().encode("pass2") )
                .roles("ADMIN")
                .build();
        UserDetails user3 = User.builder()
                .username("Guest")
                .password(passwordEncoder().encode("pass3") )
                .roles("GUEST")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

}
