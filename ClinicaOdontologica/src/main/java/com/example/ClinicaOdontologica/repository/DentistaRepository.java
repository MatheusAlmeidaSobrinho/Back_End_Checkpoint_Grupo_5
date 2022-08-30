package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Dentista;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DentistaRepository {
    private static Map<Integer, Dentista> dentistaMap = new HashMap<>();

    private static int idDentista = 1;

    public Dentista cadastrar(@NotNull Dentista dentista) {
        dentista.setId(idDentista++);
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }

    public Dentista consultarPorId(int id) {
        return dentistaMap.get(id);
    }

    public Dentista atualizar(Dentista dentista){
        return null;
    }

    public Dentista excluirPorId(int id) {
        return null;
    }

}
