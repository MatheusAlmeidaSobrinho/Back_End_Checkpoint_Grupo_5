package com.example.ClinicaOdontologica.validacoes;

import com.example.ClinicaOdontologica.common.exception.VariableNullException;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;

import java.util.ArrayList;
import java.util.List;

public class ValidationDentista {

    public Boolean validationProductVariables(DentistaDTO dentistaDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (dentistaDTO.getNome() == null || dentistaDTO.getNome().isEmpty()) {
            variables.add("Nome");
        }
        if (dentistaDTO.getSobrenome().isEmpty()) {
            variables.add("Sobrenome");
        }
        if (dentistaDTO.getCro() == null ) {
            variables.add("Data");
        }

        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }
}