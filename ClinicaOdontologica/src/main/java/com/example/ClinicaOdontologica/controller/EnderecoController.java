package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.service.impl.EnderecoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoServiceImpl enderecoService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping()
    @Transactional
    public EnderecoDTO cadastrar(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.cadastrar(enderecoDTO);
    }

//    @PostMapping()
//    @Transactional
//    public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody EnderecoDTO enderecoDTO) {
//        ResponseEntity responseEntity = null;
//
//        if (enderecoDTO.getRua() != null) {
//            EnderecoDTO enderecoDTO1 = enderecoService.cadastrar(enderecoDTO);
//            responseEntity = new ResponseEntity(enderecoDTO1, HttpStatus.OK);
//        } else {
//            responseEntity = new ResponseEntity("Data não preenchida", HttpStatus.BAD_REQUEST);
//        }
//
//        return responseEntity;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(enderecoService.consultarPorId(id), EnderecoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return ResponseEntity.ok().body(enderecoService.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.atualizar(id,enderecoDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable Integer id){
        enderecoService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
