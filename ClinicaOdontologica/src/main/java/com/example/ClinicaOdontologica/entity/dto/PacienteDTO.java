package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.Data;

import java.util.Date;

@Data
public class PacienteDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer enderecoId;
    private String rg;
    private Date dataDeAlta;
    private Roles roles;
    private String email;
    private String senha;

}
