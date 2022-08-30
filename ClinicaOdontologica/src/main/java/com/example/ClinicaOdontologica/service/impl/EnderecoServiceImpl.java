package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO cadastrar(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        enderecoRepository.cadastrar(endereco);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO consultarPorId(int id) {
        return new EnderecoDTO(enderecoRepository.consultarPorId(id));
    }

    @Override
    public EnderecoDTO atualizar(EnderecoDTO enderecoDTO) {
        return null;
    }

    @Override
    public EnderecoDTO excluirPorId(int id) {
        return null;
    }
}