package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    //@ResponseStatus(HttpStatus.CREATED) // precisa? qual a finalidade?
    @Transactional
    public ResponseEntity<PacienteDTO> cadastrar(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;

        if (pacienteDTO.getNome() != null) {
            PacienteDTO pacienteDTO1 = pacienteService.cadastrar(pacienteDTO);
            responseEntity = new ResponseEntity(pacienteDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Nome não preenchido", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(pacienteService.consultarPorId(id), PacienteDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() {
        return ResponseEntity.ok().body(pacienteService.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDTO> atualizar(@PathVariable Integer id, @RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok().body(pacienteService.atualizar(id, pacienteDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable Integer id) {
        pacienteService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
