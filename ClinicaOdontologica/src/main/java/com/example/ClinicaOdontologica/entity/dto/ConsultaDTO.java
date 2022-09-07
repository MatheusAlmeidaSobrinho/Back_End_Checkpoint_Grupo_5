package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.Paciente;
import lombok.Data;

import java.util.Date;

@Data
public class ConsultaDTO {

    private Integer id;

    private Integer paciente_id;

    private Integer dentista_id;

    private Date data;

}
