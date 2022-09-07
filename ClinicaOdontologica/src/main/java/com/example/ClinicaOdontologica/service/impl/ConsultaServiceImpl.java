package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public ConsultaDTO atualizar(Integer id, ConsultaDTO consultaDTO) {
        return null;
    }

    @Override
    public void excluirPorId(Integer id) {
        consultaRepository.deleteById(id);
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }
}
