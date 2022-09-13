package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping()
    @Transactional
    public DentistaDTO cadastrar(@RequestBody DentistaDTO dentistaDTO){
        return dentistaService.cadastrar(dentistaDTO);
    }

    @GetMapping("/{id}")
    public DentistaDTO consultarPorId(@PathVariable int id) {
        return dentistaService.consultarPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public DentistaDTO atualizar(@PathVariable Integer id, @RequestBody DentistaDTO dentistaDTO){
        return dentistaService.atualizar(id, dentistaDTO);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public String excluirPorId(@PathVariable int id){
        dentistaService.excluirPorId(id);
        return "Dentista deletado com sucesso";
    }

}