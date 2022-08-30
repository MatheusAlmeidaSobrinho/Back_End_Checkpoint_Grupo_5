package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping("/cadastrar")
    public DentistaDTO cadastrar(@RequestBody DentistaDTO dentistaDTO){
        return dentistaService.cadastrar(dentistaDTO);
    }

    @GetMapping("/consultarPorId/{id}")
    public DentistaDTO consultarPorId(@PathVariable int id){
        return dentistaService.consultarPorId(id);
    }

    @PutMapping("/atualizar")
    public DentistaDTO atualizar(@RequestBody DentistaDTO dentistaDTO){
        return dentistaService.atualizar(dentistaDTO);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public DentistaDTO excluirPorId(@PathVariable int id){
        return dentistaService.excluirPorId(id);
    }

}