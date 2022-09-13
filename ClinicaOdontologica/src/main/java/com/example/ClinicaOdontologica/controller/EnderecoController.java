package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.service.impl.EnderecoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoServiceImpl enderecoService;

    @Autowired
    private ModelMapper mapper;

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoDTO> atualizarPorPacienteId(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.atualizar(id, enderecoDTO));
    }

}
