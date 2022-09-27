package com.example.ClinicaOdontologica.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EnderecoDTO {

    private Integer id;

    @NotEmpty(message = "{campo.rua.obrigatorio}")
    private String rua;

    @NotNull(message = "{campo.numero.obrigatorio}")
    private Integer numero;

    @NotEmpty(message = "{campo.bairro.obrigatorio}")
    private String bairro;

    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;

    @NotEmpty(message = "{campo.cep.obrigatorio}")
    private String cep;
}
