package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.common.exception.PasswordInvalidException;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.entity.dto.TokenDTO;
import com.example.ClinicaOdontologica.security.JwtService;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private JwtService jwtService;

    @PostMapping()
    @Transactional
    public ResponseEntity<DentistaDTO> cadastrar(@RequestBody @Valid DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity;

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
        return ResponseEntity.ok().body(dentistaService.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> findAll() {
        return ResponseEntity.ok().body(dentistaService.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DentistaDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid DentistaDTO dentistaDTO) {
        return ResponseEntity.ok().body(dentistaService.atualizar(id, dentistaDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable int id) {
        dentistaService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/auth")
    @Transactional
    public ResponseEntity<TokenDTO> createAuthenticationToken(@RequestBody @Valid CredenciaisDTO credenciais) {
        try {
            dentistaService.autenticar(credenciais);
            final String jwt = jwtService.gerarToken(credenciais);

            return ResponseEntity.ok(new TokenDTO(credenciais.getLogin(), jwt));

        } catch (BadCredentialsException | PasswordInvalidException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}