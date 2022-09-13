package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.service.impl.EnderecoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoServiceImpl enderecoService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity cadastrar(@RequestBody EnderecoDTO enderecoDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(enderecoService.cadastrar(mapper.map(enderecoDTO, Endereco.class))).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(enderecoService.consultarPorId(id), EnderecoDTO.class));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Endereco> atualizar(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.atualizar(id, mapper.map(enderecoDTO,Endereco.class)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable Integer id){
        enderecoService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
