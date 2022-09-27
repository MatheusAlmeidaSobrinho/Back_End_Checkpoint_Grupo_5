package com.example.ClinicaOdontologica.builder;

import com.example.ClinicaOdontologica.endpoint.PacienteEndpoint;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import common.PacienteMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteBuilder {

    private final PacienteMock pacienteMock = new PacienteMock();

    @Autowired
    PacienteEndpoint pacienteEndpoint;

    public ResponseEntity<String> create(String token) throws Exception {
        return pacienteEndpoint.save(createDTO(), token);
    }

    public PacienteDTO createDTO() {
        return pacienteMock.getPacienteRequestDTO();
    }


}
