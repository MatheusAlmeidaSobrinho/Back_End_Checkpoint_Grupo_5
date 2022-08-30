package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping("/cadastrar")
    public PacienteDTO cadastrar(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.cadastrar(pacienteDTO);
    }

    @GetMapping("/consultarPorId/{id}")
    public PacienteDTO consultarPorId(@PathVariable int id){
        return pacienteService.consultarPorId(id);
    }

    @PutMapping("/atualizar")
    public PacienteDTO atualizar(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.atualizar(pacienteDTO);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public PacienteDTO excluirPorId(@PathVariable int id){
        return pacienteService.excluirPorId(id);
    }

}
