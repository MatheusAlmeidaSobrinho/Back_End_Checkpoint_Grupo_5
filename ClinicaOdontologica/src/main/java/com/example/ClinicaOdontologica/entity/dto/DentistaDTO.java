package com.example.ClinicaOdontologica.entity.dto;

import lombok.Data;

@Data
public class DentistaDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String cro;
    private Integer matricula;

}
