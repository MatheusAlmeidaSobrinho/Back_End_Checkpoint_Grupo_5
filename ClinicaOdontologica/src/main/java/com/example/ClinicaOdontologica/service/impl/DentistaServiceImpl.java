package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO cadastrar(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista(dentistaDTO);
        dentistaRepository.cadastrar(dentista);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO consultarPorId(int id) {
        return new DentistaDTO(dentistaRepository.consultarPorId(id));
    }

    @Override
    public DentistaDTO atualizar(DentistaDTO dentistaDTO) {
        return null;
    }

    @Override
    public DentistaDTO excluirPorId(int id) {
        return null;
    }
}