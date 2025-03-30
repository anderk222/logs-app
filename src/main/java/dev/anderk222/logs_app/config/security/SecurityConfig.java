package dev.anderk222.logs_app.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean 
    InMemoryUserDetailsManager userDetailsService(){

        UserDetails user1 = User.withUsername("anderk222").password("$2a$10$NNyXSZDz32hwojscQU3qCObBz7oV8kGTCkayBWkPPtmp2ZPN7XNQy").build();  
        UserDetails user2 = User.withUsername("anderk2333").password("$2a$10$FxOsmAVas8dVjC1eHZ25Kej1117iSiCSV/BpyMFi2Uriy7kqU/LFO").build();  

        return new InMemoryUserDetailsManager(user1, user2);

    }

    @Bean BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


    // @Bean 
    // public JwtDecoder jwtDecoder(){



    // } 

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return http
        .authorizeHttpRequests(authorize->authorize
        .requestMatchers(HttpMethod.GET,"/encode").permitAll()
        .requestMatchers(HttpMethod.POST, "/login")
        .permitAll()
        .anyRequest().authenticated())
        .oauth2ResourceServer(e->e.jwt(Customizer.withDefaults()))
        .build();
    }
    
}
