package com.example.ClinicaOdontologica.entity.dto;

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

}
