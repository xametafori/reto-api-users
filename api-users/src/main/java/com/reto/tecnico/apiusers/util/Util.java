package com.reto.tecnico.apiusers.util;
import java.io.IOException;
import com.reto.tecnico.apiusers.model.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Util {
	private static final Logger log = LoggerFactory.getLogger(Util.class);

	public static ResponseDTO getResponseDto(String msgError) {
		ObjectMapper objectMapper;
		ResponseDTO response;
		try {
			objectMapper = new ObjectMapper();
			return objectMapper.readValue(msgError, ResponseDTO.class);
		} catch (IOException e) {
			response = new ResponseDTO();
			response.setMensaje(msgError);
			return response;
		}
	}
}
