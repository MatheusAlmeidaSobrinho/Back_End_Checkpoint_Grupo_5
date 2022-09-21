package com.example.ClinicaOdontologica.validacoes;

import com.example.ClinicaOdontologica.common.exception.VariableNullException;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;

import java.util.ArrayList;
import java.util.List;

public class ValidationPaciente {

    public Boolean validationProductVariables(PacienteDTO pacienteDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (pacienteDTO.getNome() == null || pacienteDTO.getNome().isEmpty()) {
            variables.add("Nome");
        }
        if (pacienteDTO.getSobrenome().isEmpty()) {
            variables.add("Sobrenome");
        }
        if (pacienteDTO.getEnderecoId() <= 0) {
            variables.add("Endereco Id");
        }
        if (pacienteDTO.getRg().isEmpty()) {
            variables.add("RG");
        }
        if (pacienteDTO.getDataDeAlta() == null) {
            variables.add("Data");
        }

        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }
}