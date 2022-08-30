package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @PostMapping("/cadastrar")
    public EnderecoDTO cadastrar(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.cadastrar(enderecoDTO);
    }

    @GetMapping("/consultarPorId/{id}")
    public EnderecoDTO consultarPorId(@PathVariable int id){
        return enderecoService.consultarPorId(id);
    }

    @PutMapping("/atualizar")
    public EnderecoDTO atualizar(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.atualizar(enderecoDTO);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public EnderecoDTO excluirPorId(@PathVariable int id){
        return enderecoService.excluirPorId(id);
    }

}
