package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping("/cadastrar")
    public ConsultaDTO cadastrar(@RequestBody ConsultaDTO consultaDTO){
        return consultaService.cadastrar(consultaDTO);
    }

    @GetMapping()
    public List<Consulta> consultarPorId(){
        return consultaService.findAll();
    }

    @GetMapping("/consultarPorId/{id}")
    public ConsultaDTO consultarPorId(@PathVariable int id){
        return consultaService.consultarPorId(id);
    }


    @PutMapping("/atualizar/{id}")
    public ConsultaDTO atualizar(@PathVariable Integer id, @RequestBody ConsultaDTO consultaDTO){
        return consultaService.atualizar(id, consultaDTO);
    }

    @DeleteMapping("/excluirPorId/{id}")
    public String excluirPorId(@PathVariable int id){
         consultaService.excluirPorId(id);
         return "Consulta removida com sucesso";
    }

}
