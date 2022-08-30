package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {


    @Override
    public PacienteDTO consultarPorId(int id) {
        return null;
    }

    @Override
    public PacienteDTO cadastrar(PacienteDTO pacienteDTO) {
        return null;
    }

    @Override
    public PacienteDTO atualizar(PacienteDTO pacienteDTO) {
        return null;
    }

    @Override
    public PacienteDTO excluirPorId(int id) {
        return null;
    }
}
