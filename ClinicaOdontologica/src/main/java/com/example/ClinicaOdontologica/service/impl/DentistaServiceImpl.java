package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFound;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO cadastrar(DentistaDTO dentistaDTO) {
        dentistaRepository.save(modelMapper.map(dentistaDTO, Dentista.class));
        return dentistaDTO;
    }


    public List<DentistaDTO> findAll() {
        return  dentistaRepository.findAll().stream()
                .map(dentistas -> modelMapper.map(dentistas, DentistaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DentistaDTO consultarPorId(Integer id) {
        Optional<Dentista> dentista = dentistaRepository.findById(id);
        if(dentista.isEmpty()){
            throw new NotFound("Dentista não encontrado!");
        }
        return modelMapper.map(dentista.get(), DentistaDTO.class);
    }

    @Override
    public DentistaDTO atualizar(Integer id, DentistaDTO dentistaDTO) {
        return null;
    }

    @Override
    public void excluirPorId(Integer id) {

    }
}