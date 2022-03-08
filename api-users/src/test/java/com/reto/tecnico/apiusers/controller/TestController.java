package com.reto.tecnico.apiusers.controller;

import com.reto.tecnico.apiusers.model.UsersResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestController {


 	@Autowired
    private TestRestTemplate template;

	@Test
	void obtenerDatosTest() throws Exception{
		ResponseEntity<UsersResponse> result = template.getForEntity("https://reqres.in/api/users", UsersResponse.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
