package com.example.ClinicaOdontologica.common.config;

import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;

public class ValidationPaciente {

    public String ValidacaoDePaciente(PacienteDTO pacienteDTO) {
        if (pacienteDTO.getId() == null) {
            return "ID nulo";
        } else if (pacienteDTO.getNome() == null) {
            return "Nome nulo";
        }
        return null;
    }
}
