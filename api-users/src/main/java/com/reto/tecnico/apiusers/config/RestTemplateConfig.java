package com.reto.tecnico.apiusers.config;


import com.reto.tecnico.apiusers.excepcion.ApiUsersRestTemplateErrorHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {


    @Bean
    @Qualifier("restTemplateApiUsers")
    public RestTemplate restTemplateApiUsers(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder.errorHandler(new ApiUsersRestTemplateErrorHandler()).build();
    }
}
