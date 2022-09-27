package com.example.ClinicaOdontologica.builder;

import com.example.ClinicaOdontologica.endpoint.EnderecoEndpoint;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import common.EnderecoMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EnderecoBuilder {

    private final EnderecoMock enderecoMock = new EnderecoMock();

    @Autowired
    EnderecoEndpoint enderecoEndpoint;

    public ResponseEntity<String> create(String token) throws Exception {
        return enderecoEndpoint.save(createDTO(), token);
    }

    public EnderecoDTO createDTO() {
        return enderecoMock.getEnderecoRequestDTO();
    }


}
