package com.example.ClinicaOdontologica.validacoes;

import com.example.ClinicaOdontologica.common.exception.VariableNullException;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;

import java.util.ArrayList;
import java.util.List;

public class ValidationEndereco {

    public Boolean validationProductVariables(EnderecoDTO enderecoDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (enderecoDTO.getRua() == null || enderecoDTO.getRua().isEmpty()) {
            variables.add("Rua");
        }
        if (enderecoDTO.getNumero() <= 0) {
            variables.add("Numero");
        }
        if (enderecoDTO.getBairro() == null || enderecoDTO.getBairro().isEmpty()) {
            variables.add("Bairro");
        }
        if (enderecoDTO.getCidade() == null || enderecoDTO.getCidade().isEmpty()) {
            variables.add("Cidade");
        }
        if (enderecoDTO.getCep() == null || enderecoDTO.getCep().isEmpty()) {
            variables.add("Cep");
        }

        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }
}
