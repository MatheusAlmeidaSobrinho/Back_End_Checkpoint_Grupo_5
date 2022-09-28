package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO cadastrar(EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.save(convertEnderecoDTOIntoEndereco(enderecoDTO));
        return convertEnderecoIntoEnderecoDTO(endereco);
    }

    @Override
    public EnderecoDTO consultarPorId(Integer id) {
        Optional<Endereco> address = enderecoRepository.findById(id);
        if (address.isEmpty()) {
            throw new NotFoundException("Endereço não encontrado!");
        }
        return convertEnderecoIntoEnderecoDTO(address.get());
    }

    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll().stream()
                .map(this::convertEnderecoIntoEnderecoDTO).collect(Collectors.toList());
    }

    @Override
    public EnderecoDTO atualizar(Integer id, EnderecoDTO enderecoDTO) {
        EnderecoDTO addressById = consultarPorId(id);
        enderecoDTO.setId(addressById.getId());

        Endereco address = convertEnderecoDTOIntoEndereco(enderecoDTO);
        Endereco addressSaved = enderecoRepository.saveAndFlush(address);

        return convertEnderecoIntoEnderecoDTO(addressSaved);
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        enderecoRepository.deleteById(id);
    }

    public Endereco convertEnderecoDTOIntoEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .id(enderecoDTO.getId())
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .bairro(enderecoDTO.getBairro())
                .cidade(enderecoDTO.getCidade())
                .cep(enderecoDTO.getCep())
                .build();
    }

    private EnderecoDTO convertEnderecoIntoEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .cep(endereco.getCep())
                .build();
    }
}