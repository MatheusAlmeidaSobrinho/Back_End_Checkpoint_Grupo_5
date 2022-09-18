package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFound;
import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

//    @Override
//    public EnderecoDTO cadastrar(EnderecoDTO enderecoDTO) {
//        Endereco endereco = new Endereco(enderecoDTO);
//        endereco = enderecoRepository.save(endereco);
//        enderecoDTO = new EnderecoDTO(endereco);
//        return enderecoDTO;
//    }

    public List<EnderecoDTO> findAll() {
        return  enderecoRepository.findAll().stream()
                .map(enderecos -> modelMapper.map(enderecos, EnderecoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EnderecoDTO consultarPorId(Integer id) {
        Optional<Endereco> address = enderecoRepository.findById(id);
        if(address.isEmpty()){
            throw new NotFound("Endereço não encontrado!");
        }
        return modelMapper.map(address.get(), EnderecoDTO.class);
    }

    @Override
    public EnderecoDTO atualizar(Integer id ,EnderecoDTO enderecoDTO) {
        EnderecoDTO address  = consultarPorId(id);
        enderecoDTO.setId(address.getId());
        enderecoRepository.saveAndFlush(modelMapper.map(enderecoDTO, Endereco.class));
        return enderecoDTO;
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        enderecoRepository.deleteById(id);
    }

    public boolean ifEnderecoExists(int id) {
        return enderecoRepository.existsById(id);
    }

}