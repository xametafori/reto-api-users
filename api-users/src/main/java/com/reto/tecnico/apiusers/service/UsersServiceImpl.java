package com.reto.tecnico.apiusers.service;

import com.reto.tecnico.apiusers.model.ApiUsersResponse;
import com.reto.tecnico.apiusers.model.ResponseDTO;
import com.reto.tecnico.apiusers.model.UsersResponse;
import com.reto.tecnico.apiusers.util.UsersRestCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRestCall usersRestCall;

    @Override
    public ResponseDTO obtenerUsers() {
        ResponseDTO oResponseDTO= new ResponseDTO();
        UsersResponse oUsersResponse=usersRestCall.obtenerDatos();
        if(Objects.isNull(oUsersResponse) || Objects.isNull(oUsersResponse.getData())){
            oResponseDTO.setCodigo(-1);
            oResponseDTO.setMensaje("ERROR");
        }else{
            oResponseDTO.setData(obtenerRespones(oUsersResponse));
            oResponseDTO.setCodigo(0);
            oResponseDTO.setMensaje("OK");
        }
        return oResponseDTO;
    }
    private List<ApiUsersResponse> obtenerRespones(UsersResponse oUsersResponse){

        return oUsersResponse.getData().stream()
                .map(request -> {
                    ApiUsersResponse oApiUsersResponse = new ApiUsersResponse();
                    oApiUsersResponse.setId(request.getId());
                    oApiUsersResponse.setLast_name(request.getLast_name());
                    oApiUsersResponse.setEmail(request.getEmail());
                    return oApiUsersResponse;
                })
                .collect(Collectors.toList());
    }
}
