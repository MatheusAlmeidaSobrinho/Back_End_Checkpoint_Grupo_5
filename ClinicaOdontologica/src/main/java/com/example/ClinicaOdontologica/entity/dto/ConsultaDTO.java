package com.example.ClinicaOdontologica.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ConsultaDTO {

    private Integer id;

    @NotNull(message = "{campo.id-paciente.obrigatorio}")
    private Integer pacienteId;

    @NotNull(message = "{campo.id-dentista.obrigatorio}")
    private Integer dentistaId;

    @NotEmpty(message = "{campo.data-consulta.obrigatorio}")
    private Date data;

}
