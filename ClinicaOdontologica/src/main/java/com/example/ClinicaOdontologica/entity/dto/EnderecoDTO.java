package com.example.ClinicaOdontologica.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EnderecoDTO {

    private Integer id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;
}
