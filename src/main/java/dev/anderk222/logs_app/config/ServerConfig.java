package dev.anderk222.logs_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServerConfig {
    
    @Bean
    RestTemplate restTemplate(){
        
        return new RestTemplate();

    }

}
