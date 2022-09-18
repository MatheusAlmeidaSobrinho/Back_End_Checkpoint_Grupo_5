package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> findAll() {
        return ResponseEntity.ok().body(dentistaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaDTO> consultarPorId(@PathVariable int id) {
        return ResponseEntity.ok().body(dentistaService.consultarPorId(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DentistaDTO> atualizar(@PathVariable Integer id, @RequestBody DentistaDTO dentistaDTO){
        return ResponseEntity.ok().body(dentistaService.atualizar(id, dentistaDTO));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable int id){
        dentistaService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

}