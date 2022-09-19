package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFound;
import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public ConsultaDTO cadastrar(ConsultaDTO consultaDTO) {
        consultaRepository.save(modelMapper.map(consultaDTO, Consulta.class));
        return consultaDTO;
    }

    @Override
    public ConsultaDTO consultarPorId(Integer id) {
        Optional<Consulta> optional = consultaRepository.findById(id);
        if (!optional.isPresent()) {
            throw new NotFound("Id não encontrado");
        }
        return modelMapper.map(optional, ConsultaDTO.class);
    }

    @Override
    public ConsultaDTO atualizar(Integer id, ConsultaDTO consultaDTO) {
        return null;
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        consultaRepository.deleteById(id);
    }

    @Override
    public List<ConsultaDTO> findAll() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaDTO> consultaDTOS = new ArrayList<>();

        for (Consulta consulta : consultas) {
            ConsultaDTO consultaDTO = modelMapper.map(consulta, ConsultaDTO.class);
            consultaDTOS.add(consultaDTO);
        }
        return consultaDTOS;
    }
}
