package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.Paciente;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PacienteRepository {
    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();

    private static int idPaciente = 1;

    public Paciente cadastrar(@NotNull Paciente paciente) {
        paciente.setId(idPaciente++);
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }

    public Paciente consultarPorId(int id) {
        return pacienteMap.get(id);
    }

    public Paciente atualizar(Paciente paciente){
        return null;
    }

    public Paciente excluirPorId(int id) {
        return null;
    }

}
