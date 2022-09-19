package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    @Transactional
    public ResponseEntity<DentistaDTO> cadastrar(@RequestBody DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity = null;

        if (dentistaDTO.getMatricula() != null) {
            DentistaDTO dentistaDTO1 = dentistaService.cadastrar(dentistaDTO);
            responseEntity = new ResponseEntity(dentistaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Matricula não preenchida", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modelMapper.map(dentistaService.consultarPorId(id), DentistaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> findAll() {
        return ResponseEntity.ok().body(dentistaService.findAll());
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