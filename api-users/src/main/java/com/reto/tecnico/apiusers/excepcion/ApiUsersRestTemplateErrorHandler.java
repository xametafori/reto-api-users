package com.reto.tecnico.apiusers.excepcion;

import com.reto.tecnico.apiusers.model.ResponseDTO;
import com.reto.tecnico.apiusers.util.Util;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ApiUsersRestTemplateErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
                String httpBodyResponse = reader.lines().collect(Collectors.joining(""));
                ResponseDTO objResponseDTO = Util.getResponseDto(httpBodyResponse);
                String mensaje = DownstreamApi.API_USERS.toString().concat(": ")
                        .concat(objResponseDTO.getMensaje());
                throw new ModelRestTemplateException(response.getStatusCode(), mensaje);
            }
        }
    }
}
