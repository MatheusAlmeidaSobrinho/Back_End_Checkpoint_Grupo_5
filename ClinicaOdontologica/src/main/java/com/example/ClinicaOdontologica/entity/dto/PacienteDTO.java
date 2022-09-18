package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class PacienteDTO {

    @JsonIgnore
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer endereco_id;
    private String rg;
    private Date dataDeAlta;

}
