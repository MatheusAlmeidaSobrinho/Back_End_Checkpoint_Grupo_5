package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping()
    @Transactional
    public ResponseEntity<ConsultaDTO> cadastrar(@RequestBody @Valid ConsultaDTO consultaDTO) {
        ResponseEntity responseEntity;

        if (consultaDTO.getDentistaId() != null && consultaDTO.getPacienteId() != null) {
            ConsultaDTO consultaDTO1 = consultaService.cadastrar(consultaDTO);
            responseEntity = new ResponseEntity(consultaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Paciente ou Dentista não preenchido", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(consultaService.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        return ResponseEntity.ok().body(consultaService.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ConsultaDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid ConsultaDTO consultaDTO) {
        return ResponseEntity.ok().body(consultaService.atualizar(id, consultaDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable Integer id) {
        consultaService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
