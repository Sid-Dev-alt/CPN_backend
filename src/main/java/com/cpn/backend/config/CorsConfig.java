package com.cpn.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:5173",
                                "https://sid-dev-alt.github.io",
                                "https://cpn-foods-homepage.onrender.com",
                                "https://cpnfoods.com",
                                "https://www.cpnfoods.com",
                                "http://168.144.112.207"
                        )
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}