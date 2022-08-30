package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.Endereco;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EnderecoRepository {
    private static Map<Integer, Endereco> enderecoMap = new HashMap<>();

    private static int idEndereco = 1;

    public Endereco cadastrar(@NotNull Endereco endereco) {
        endereco.setId(idEndereco++);
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }

    public Endereco consultarPorId(int id) {
        return enderecoMap.get(id);
    }

    public Endereco atualizar(Endereco endereco){
        return null;
    }

    public Endereco excluirPorId(int id) {
        return null;
    }

}
