package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConsultaRepository {

    @Autowired
    private ModelMapper mapper;

    private static Map<Integer, Consulta> consultaMap = new HashMap<>();

    private static int idConsulta = 1;

    public Consulta cadastrar(@NotNull Consulta consulta) {
        consulta.setId(idConsulta++);
        consultaMap.put(consulta.getId(), consulta);
        return consulta;
    }

    public Consulta consultarPorId(int id) {
        return null;
    }

    public Consulta atualizar(Consulta consulta){
        return null;
    }

    public void excluirPorId(int id) {
       consultaMap.remove(id);
    }

    public List<Consulta> findAll() {
        return consultaMap.values().stream().toList();
    }
}
