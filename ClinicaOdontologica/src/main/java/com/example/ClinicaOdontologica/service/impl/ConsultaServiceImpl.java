package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {


    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public ConsultaDTO cadastrar(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);
        consultaRepository.cadastrar(consulta);
        return consultaDTO;
    }

    @Override
    public ConsultaDTO consultarPorId(int id) {
        return null;
    }

    @Override
    public ConsultaDTO atualizar(ConsultaDTO consultaDTO) {
        return null;
    }

    @Override
    public ConsultaDTO excluirPorId(int id) {
        return null;
    }
}
