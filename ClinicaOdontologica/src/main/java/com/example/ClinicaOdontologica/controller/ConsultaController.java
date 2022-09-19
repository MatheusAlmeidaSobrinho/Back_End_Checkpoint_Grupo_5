package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping()
    @Transactional
    public ConsultaDTO cadastrar(@RequestBody ConsultaDTO consultaDTO) {
        return consultaService.cadastrar(consultaDTO);
    }

    @GetMapping()
    public List<ConsultaDTO> listaConsultas() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public ConsultaDTO consultarPorId(@PathVariable int id) {
        return consultaService.consultarPorId(id);
    }


    @PutMapping("/{id}")
    @Transactional
    public ConsultaDTO atualizar(@PathVariable Integer id, @RequestBody ConsultaDTO consultaDTO) {
        return consultaService.atualizar(id, consultaDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String excluirPorId(@PathVariable int id) {
        consultaService.excluirPorId(id);
        return "Consulta removida com sucesso";
    }

}
