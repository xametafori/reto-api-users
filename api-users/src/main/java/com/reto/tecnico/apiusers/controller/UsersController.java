package com.reto.tecnico.apiusers.controller;


import com.reto.tecnico.apiusers.model.ResponseDTO;
import com.reto.tecnico.apiusers.service.UsersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@Api(value = "consulta de users", produces = "application/json", tags = { "users" })
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "Consulta de users")
    @GetMapping("")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "lista encontrado", response = ResponseDTO.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ResponseDTO.class) })
    public ResponseEntity<ResponseDTO> consultaMovimientos() {
        ResponseDTO objResponseDTO = this.usersService.obtenerUsers();
        return new ResponseEntity<>(objResponseDTO, HttpStatus.OK);
    }

}
