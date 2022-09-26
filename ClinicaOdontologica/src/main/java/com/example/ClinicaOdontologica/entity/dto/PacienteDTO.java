package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PacienteDTO {

    private Integer id;

    @NotEmpty(message = "{campo.endereco.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.sobrenome.obrigatorio}")
    private String sobrenome;

    @NotNull(message = "{campo.endereco.obrigatorio}")
    private Integer enderecoId;

    @NotEmpty(message = "{campo.rg.obrigatorio}")
    private String rg;
    private Date dataDeAlta;

    @NotNull(message = "{campo.roles.obrigatorio}")
    private Roles roles;
    private String email;
    private String senha;

}
