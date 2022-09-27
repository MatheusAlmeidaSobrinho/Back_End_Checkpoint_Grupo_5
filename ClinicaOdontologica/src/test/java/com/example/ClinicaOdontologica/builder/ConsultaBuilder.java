package com.example.ClinicaOdontologica.builder;

import com.example.ClinicaOdontologica.endpoint.ConsultaEndpoint;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import common.ConsultaMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ConsultaBuilder {

    private final ConsultaMock consultaMock = new ConsultaMock();

    @Autowired
    ConsultaEndpoint consultaEndpoint;

    public ResponseEntity<String> create(String token) throws Exception {
        return consultaEndpoint.save(createDTO(), token);
    }

    public ConsultaDTO createDTO() {
        return consultaMock.getConsultaRequestDTO();
    }


}
