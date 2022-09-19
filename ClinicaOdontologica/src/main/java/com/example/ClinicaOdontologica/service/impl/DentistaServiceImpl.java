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
        Dentista dentista = dentistaRepository.save(modelMapper.map(dentistaDTO, Dentista.class));
        return modelMapper.map(dentista, DentistaDTO.class);
    }

    @Override
    public DentistaDTO consultarPorId(Integer id) { // falta tratamento para o postman em caso do ID nao existir ainda
        Optional<Dentista> dentista = dentistaRepository.findById(id);
        if (dentista.isEmpty()) {
            throw new NotFound("Dentista não encontrado!");
        }
        return modelMapper.map(dentista.get(), DentistaDTO.class);
    }

    public List<DentistaDTO> findAll() {
        return dentistaRepository.findAll().stream()
                .map(dentistas -> modelMapper.map(dentistas, DentistaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DentistaDTO atualizar(Integer id, DentistaDTO dentistaDTO) { // falta tratamento para o postman em caso do ID nao existir ainda
        DentistaDTO dentist = consultarPorId(id);
        dentistaDTO.setId(dentist.getId());
        dentistaRepository.saveAndFlush(modelMapper.map(dentistaDTO, Dentista.class));
        return dentistaDTO;
    }

    @Override
    public void excluirPorId(Integer id) { // falta tratamento para o postman em caso do ID nao existir ainda
        consultarPorId(id);
        dentistaRepository.deleteById(id);
    }

}