package com.example.ClinicaOdontologica.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ConsultaDTO {

    private Integer id;
    private Integer pacienteId;
    private Integer dentistaId;
    private Date data;

}
