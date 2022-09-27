package com.example.ClinicaOdontologica.builder;

import com.example.ClinicaOdontologica.endpoint.DentistaEndpoint;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import common.DentistaMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DentistaBuilder {

    private final DentistaMock dentistaMock = new DentistaMock();

    @Autowired
    DentistaEndpoint dentistaEndpoint;

    public ResponseEntity<String> create(String token) throws Exception {
        return dentistaEndpoint.save(createDTO(), token);
    }

    public DentistaDTO createDTO() {
        return dentistaMock.getDentistaRequestDTO();
    }


}
