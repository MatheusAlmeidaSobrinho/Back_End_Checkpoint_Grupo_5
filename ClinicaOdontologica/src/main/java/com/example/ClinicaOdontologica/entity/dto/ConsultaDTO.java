package com.example.ClinicaOdontologica.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class ConsultaDTO {

    @JsonIgnore
    private Integer id;

    private Integer paciente_id;

    private Integer dentista_id;

    private Date data;

}
