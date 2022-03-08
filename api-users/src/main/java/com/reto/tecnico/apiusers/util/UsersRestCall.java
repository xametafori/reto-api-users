package com.reto.tecnico.apiusers.util;

import com.reto.tecnico.apiusers.model.UsersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

@Component
public class UsersRestCall {

    private static final Logger log = LoggerFactory.getLogger(UsersRestCall.class);
    @Value("${path.obtenerdatos}") private String urlObtenerUsers;

    @Value("${dominio.users}")
    private String dominioUsers;

    private final RestTemplate restTemplateApiUsers;

    @Autowired
    public UsersRestCall(@Qualifier("restTemplateApiUsers") RestTemplate restTemplateApiUsers) {
        this.restTemplateApiUsers = restTemplateApiUsers;
    }

    public UsersResponse obtenerDatos() {
        log.info("llamada al metodo obtenerDatos ");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
                dominioUsers
                        .concat(urlObtenerUsers));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");


        HttpEntity<?> entity = new HttpEntity<>(headers);
        UsersResponse response = new UsersResponse();
        log.info("llamada al metodo obtenerDatos URL:{} ",builder.build());

        try {
            response = restTemplateApiUsers.exchange(
                            builder.toUriString(),
                            HttpMethod.GET,
                            entity,
                            UsersResponse.class)
                    .getBody();
        } catch (Exception e) {
            log.info("Error al obtener los datos: {}", e.getMessage());
        }

        return response;
    }

}
