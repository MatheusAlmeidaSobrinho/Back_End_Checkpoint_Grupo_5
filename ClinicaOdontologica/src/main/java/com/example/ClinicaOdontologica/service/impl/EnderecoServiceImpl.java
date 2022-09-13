package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFound;
import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO cadastrar(EnderecoDTO enderecoDTO) {
        enderecoRepository.save(modelMapper.map(enderecoDTO, Endereco.class));
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO consultarPorId(Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isEmpty()){
            throw new NotFound("Endereço não encontrado!");
        }
        return modelMapper.map(endereco.get(), EnderecoDTO.class);
    }

    @Override
    public EnderecoDTO atualizar(Integer id, EnderecoDTO dentistaDTO) {
        return null;
    }

    @Override
    public void excluirPorId(Integer id) {

    }
}