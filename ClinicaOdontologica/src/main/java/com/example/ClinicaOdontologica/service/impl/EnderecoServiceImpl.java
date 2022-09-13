package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFound;
import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements IClinicaService<Endereco> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco cadastrar(Endereco endereco) {
        enderecoRepository.save(modelMapper.map(endereco, Endereco.class));
        return endereco;
    }

    @Override
    public Endereco consultarPorId(Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isEmpty()){
            throw new NotFound("Endereço não encontrado!");
        }
        return modelMapper.map(endereco.get(), Endereco.class);
    }

    @Override
    public Endereco atualizar(Integer id, Endereco endereco) {
        Endereco adress = this.consultarPorId(id);
        return enderecoRepository.save(this.atualizarDadosEndereco(adress,endereco));
    }

    @Override
    public void excluirPorId(Integer id) {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            enderecoRepository.deleteById(id);
            ResponseEntity.ok().build();
        }

        ResponseEntity.notFound().build();
    }

    private Endereco atualizarDadosEndereco(Endereco endereco, Endereco obj) {
        endereco.setRua(obj.getRua());
        endereco.setNumero(obj.getNumero());
        endereco.setBairro(obj.getBairro());
        endereco.setCidade(obj.getCidade());
        endereco.setCep(obj.getCep());

        return endereco;
    }

}