package com.reto.tecnico.apiusers.util;

import com.reto.tecnico.apiusers.model.DataUsersResponse;
import com.reto.tecnico.apiusers.model.SupportUsersResponse;
import com.reto.tecnico.apiusers.model.UsersResponse;

import java.util.ArrayList;
import java.util.List;

public class DatosUtil {
    public static UsersResponse obtenerDatosUsers() {
        UsersResponse response = new UsersResponse();
        response.setPage(1);
        response.setPer_page(6);
        response.setTotal(12);
        response.setTotal(2);
        SupportUsersResponse support =new SupportUsersResponse();
        support.setUrl("https://reqres.in/#support-heading");
        support.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

        DataUsersResponse data = new DataUsersResponse();
        List<DataUsersResponse> lstData = new ArrayList<>();
        data.setId(1);
        data.setAvatar("imagen.jpg");
        data.setEmail("xavi.ambrocio22@gmail.com");
        data.setFirst_name("xavier");
        data.setLast_name("ambrocio");
        lstData.add(data);
        response.setSupport(support);
        response.setData(lstData);
        return response;
    }

}
