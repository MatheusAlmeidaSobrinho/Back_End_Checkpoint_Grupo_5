package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity cadastrar(@RequestBody PacienteDTO pacienteDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(pacienteService.cadastrar(mapper.map(pacienteDTO, Paciente.class))).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(pacienteService.consultarPorId(id), PacienteDTO.class));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Paciente> atualizar(@PathVariable Integer id, @RequestBody PacienteDTO pacienteDTO){
        return ResponseEntity.ok().body(pacienteService.atualizar(id, mapper.map(pacienteDTO, Paciente.class)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable Integer id){
         pacienteService.excluirPorId(id);
         return ResponseEntity.noContent().build();
    }

}
