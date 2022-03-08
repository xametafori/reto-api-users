package com.reto.tecnico.apiusers.service;

import com.reto.tecnico.apiusers.model.ResponseDTO;
import com.reto.tecnico.apiusers.util.DatosUtil;
import com.reto.tecnico.apiusers.util.UsersRestCall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestService {


    @Mock
    UsersRestCall usersRestCall;

    @InjectMocks
    private UsersServiceImpl service = new UsersServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void obtenerUsersTestOK() {
        when(usersRestCall.obtenerDatos())
                .thenReturn(DatosUtil.obtenerDatosUsers());

        ResponseDTO oResponseDTO = service.obtenerUsers();
        assertEquals("OK", oResponseDTO.getMensaje());
        assertNotNull(oResponseDTO.getData());
    }

    @Test
    void obtenerUsersTestERROR() {
        when(usersRestCall.obtenerDatos())
                .thenReturn(null);

        ResponseDTO oResponseDTO = service.obtenerUsers();
        assertEquals("ERROR", oResponseDTO.getMensaje());
        assertNull(oResponseDTO.getData());
    }
}
