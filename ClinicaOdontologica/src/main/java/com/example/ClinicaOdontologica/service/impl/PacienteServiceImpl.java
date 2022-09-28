package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.common.exception.PasswordInvalidException;
import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>, UserDetailsService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails autenticar(CredenciaisDTO credenciais) {
        UserDetails user = loadUserByUsername(credenciais.getLogin());
        System.out.println("user " + user);
        System.out.println("Credenciais " + credenciais);
        boolean senhasIguais = bCryptPasswordEncoder.matches(credenciais.getSenha(), user.getPassword());

        if (senhasIguais) {
            return user;
        }
        throw new PasswordInvalidException("Senha inválida.");
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Paciente paciente = pacienteRepository.findByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String[] roles = new String[]{String.valueOf(paciente.getRoles())};

        return User
                .builder()
                .username(paciente.getEmail())
                .password(paciente.getSenha())
                .roles(roles)
                .build();
    }

    @Override
    public PacienteDTO cadastrar(PacienteDTO pacienteDTO) {
        System.out.println("DTO paciente " + pacienteDTO);
        String password = bCryptPasswordEncoder.encode(pacienteDTO.getSenha());
        pacienteDTO.setSenha(password);

        Paciente paciente = pacienteRepository.save(convertPacienteDTOIntoPaciente(pacienteDTO));
        System.out.println("Paciente salvo " + paciente);
        return convertPacienteIntoPacienteDTO(paciente);
    }

    @Override
    public PacienteDTO consultarPorId(Integer id) { // falta tratamento para o postman em caso do ID nao existir ainda
        Optional<Paciente> entity = pacienteRepository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException("Paciente não encontrado!");
        }
        return convertPacienteIntoPacienteDTO(entity.get());
    }

    @Override
    public List<PacienteDTO> findAll() {
        return pacienteRepository.findAll().stream()
                .map(this::convertPacienteIntoPacienteDTO).collect(Collectors.toList());
    }

    @Override
    public PacienteDTO atualizar(Integer id, PacienteDTO pacienteDTO) {
        PacienteDTO entity = consultarPorId(id);
        pacienteDTO.setId(entity.getId());
        Paciente paciente = convertPacienteDTOIntoPaciente(pacienteDTO);
        Paciente pacienteSaved = pacienteRepository.saveAndFlush(paciente);
        return convertPacienteIntoPacienteDTO(pacienteSaved);
    }

    @Override
    public void excluirPorId(Integer id) { // falta tratamento para o postman em caso do ID nao existir ainda
        consultarPorId(id);
        pacienteRepository.deleteById(id);
    }

    public Paciente convertPacienteDTOIntoPaciente(PacienteDTO pacienteDTO) {
        Endereco endereco = enderecoService.convertEnderecoDTOIntoEndereco(enderecoService.consultarPorId(pacienteDTO.getEnderecoId()));

        return Paciente.builder()
                .id(pacienteDTO.getId())
                .nome(pacienteDTO.getNome())
                .sobrenome(pacienteDTO.getSobrenome())
                .endereco(endereco)
                .rg(pacienteDTO.getRg())
                .dataDeAlta(pacienteDTO.getDataDeAlta())
                .email(pacienteDTO.getEmail())
                .senha(pacienteDTO.getSenha())
                .roles(pacienteDTO.getRoles())
                .build();
    }

    private PacienteDTO convertPacienteIntoPacienteDTO(Paciente paciente) {
        return PacienteDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sobrenome(paciente.getSobrenome())
                .enderecoId(paciente.getEndereco().getId())
                .rg(paciente.getRg())
                .dataDeAlta(paciente.getDataDeAlta())
                .email(paciente.getEmail())
                .senha(paciente.getSenha())
                .roles(paciente.getRoles())
                .build();
    }
}
