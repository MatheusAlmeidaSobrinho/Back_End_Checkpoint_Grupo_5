package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping("/cadastrar")
    public ConsultaDTO cadastrar(@RequestBody ConsultaDTO consultaDTO){
        return consultaService.cadastrar(consultaDTO);
    }

    @GetMapping("/consultarPorId/{id}")
    public ConsultaDTO consultarPorId(@PathVariable int id){
        return consultaService.consultarPorId(id);
    }

    @PutMapping("/atualizar")
    public ConsultaDTO atualizar(@RequestBody ConsultaDTO consultaDTO){
        return consultaService.atualizar(consultaDTO);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public ConsultaDTO excluirPorId(@PathVariable int id){
        return consultaService.excluirPorId(id);
    }

}
