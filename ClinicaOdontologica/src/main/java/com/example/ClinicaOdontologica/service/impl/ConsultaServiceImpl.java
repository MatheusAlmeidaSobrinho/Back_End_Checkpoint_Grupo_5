package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Override
    public ConsultaDTO cadastrar(ConsultaDTO consultaDTO) {
        pacienteService.consultarPorId(consultaDTO.getPacienteId());
        dentistaService.consultarPorId(consultaDTO.getDentistaId());
        Consulta consulta = consultaRepository.save(modelMapper.map(consultaDTO, Consulta.class));
        return modelMapper.map(consulta, ConsultaDTO.class);
    }

    @Override
    public ConsultaDTO consultarPorId(Integer id) {
        Optional<Consulta> consult = consultaRepository.findById(id);
        if (consult.isEmpty()) {
            throw new NotFoundException("Consulta não encontrada");
        }
        return modelMapper.map(consult.get(), ConsultaDTO.class);
    }

    @Override
    public List<ConsultaDTO> findAll() {
        return consultaRepository.findAll().stream()
                .map(consultas -> modelMapper.map(consultas, ConsultaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ConsultaDTO atualizar(Integer id, ConsultaDTO consultaDTO) {
        ConsultaDTO consult = this.consultarPorId(id);
        consultaDTO.setId(consult.getId());
        consultaRepository.saveAndFlush(modelMapper.map(consultaDTO, Consulta.class));
        return consultaDTO;
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        consultaRepository.deleteById(id);
    }

}
