package com.example.ClinicaOdontologica.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PacienteDTO {

    private String nome;
    private String sobrenome;
    private Integer endereco_id;
    private String rg;
    private Date dataDeAlta;

}
