package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.common.exception.PasswordInvalidException;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.entity.dto.TokenDTO;
import com.example.ClinicaOdontologica.security.JwtService;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
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
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/auth")
    public ResponseEntity<TokenDTO> createAuthenticationToken(@RequestBody @Valid CredenciaisDTO credenciais) {
        try {

            pacienteService.autenticar(credenciais);
            final String jwt = jwtService.gerarToken(credenciais);

            return ResponseEntity.ok(new TokenDTO(credenciais.getLogin(), jwt));

        } catch (BadCredentialsException | PasswordInvalidException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<PacienteDTO> cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;

        if (pacienteDTO.getNome() != null) {
            PacienteDTO pacienteDTO1 = pacienteService.cadastrar(pacienteDTO);
            responseEntity = new ResponseEntity(pacienteDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Nome não preenchido", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> consultarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(pacienteService.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() {
        return ResponseEntity.ok().body(pacienteService.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid PacienteDTO pacienteDTO) {
        return ResponseEntity.ok().body(pacienteService.atualizar(id, pacienteDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPorId(@PathVariable Integer id) {
        pacienteService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
