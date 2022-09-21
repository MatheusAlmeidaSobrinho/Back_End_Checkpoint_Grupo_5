package com.example.ClinicaOdontologica.validacoes;

import com.example.ClinicaOdontologica.common.exception.VariableNullException;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;

import java.util.ArrayList;
import java.util.List;

public class ValidationConsulta {

    public Boolean validationProductVariables(ConsultaDTO consultaDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (consultaDTO.getPacienteId() == null || consultaDTO.getPacienteId() <= 0 ) {
            variables.add("Id Paciente");
        }
        if (consultaDTO.getDentistaId() <= 0) {
            variables.add("Id Dentista");
        }
        if (consultaDTO.getData() == null ) {
            variables.add("Data");
        }

        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }
}
