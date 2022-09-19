package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFound;
import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PacienteDTO cadastrar(PacienteDTO pacienteDTO) {
        enderecoService.consultarPorId(pacienteDTO.getEnderecoId());
        Paciente paciente = pacienteRepository.save(modelMapper.map(pacienteDTO, Paciente.class));
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    public PacienteDTO consultarPorId(Integer id) {
        Optional<Paciente> entity = pacienteRepository.findById(id);
        if(entity.isEmpty()){
            throw new NotFound("Paciente não encontrado!");
        }
        return modelMapper.map(entity.get(), PacienteDTO.class);
    }

    @Override
    public PacienteDTO atualizar(Integer id, PacienteDTO pacienteDTO) {
        PacienteDTO entity = this.consultarPorId(id);
        pacienteDTO.setId(entity.getId());
        pacienteRepository.saveAndFlush(modelMapper.map(pacienteDTO,Paciente.class));
        return pacienteDTO;
    }

    @Override
    public void excluirPorId(Integer id) {
        this.consultarPorId(id);
        this.pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteDTO> findAll() {
        return null;
    }

}
