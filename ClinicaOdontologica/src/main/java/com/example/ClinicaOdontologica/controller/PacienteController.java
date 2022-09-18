package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.common.config.ValidationPaciente;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    @Autowired
    private ModelMapper mapper;

    private ValidationPaciente validationPaciente = new ValidationPaciente();

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    @Transactional
//    public ResponseEntity<PacienteDTO> cadastrar(@RequestBody PacienteDTO pacienteDTO) {
//        ResponseEntity responseEntity = null;
//
//        String erro = validationPaciente.ValidacaoDePaciente(pacienteDTO);
//
//        if (erro == null) {
//            PacienteDTO pacienteDTO1 = pacienteService.cadastrar(pacienteDTO);
//            if (pacienteDTO1.getId() != 0)
//                responseEntity = new ResponseEntity<>("Endereço não existe", HttpStatus.BAD_REQUEST);
//            responseEntity = new ResponseEntity<>(pacienteDTO1, HttpStatus.OK);
//        } else {
//            responseEntity = new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
//        }
//        return responseEntity;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public PacienteDTO cadastrar(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.cadastrar(pacienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(pacienteService.consultarPorId(id), PacienteDTO.class));
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
