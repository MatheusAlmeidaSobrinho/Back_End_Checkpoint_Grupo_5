package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    public PacienteDTO consultarPorId(int id) {
        return null;
    }

    @Override
    public PacienteDTO cadastrar(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        pacienteRepository.cadastrar(paciente);
        return pacienteDTO;
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
