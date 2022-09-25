package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.common.exception.PasswordInvalidException;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.modelmapper.ModelMapper;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;

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

        String[] roles = new String[] { String.valueOf(paciente.getRoles()) };

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

        Paciente paciente = pacienteRepository.save(modelMapper.map(pacienteDTO, Paciente.class));
        System.out.println("Paciente salvo " + paciente);
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    public PacienteDTO consultarPorId(Integer id) { // falta tratamento para o postman em caso do ID nao existir ainda
        Optional<Paciente> entity = pacienteRepository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException("Paciente não encontrado!");
        }
        return modelMapper.map(entity.get(), PacienteDTO.class);
    }

    @Override
    public List<PacienteDTO> findAll() {
        return pacienteRepository.findAll().stream()
                .map(pacientes -> modelMapper.map(pacientes, PacienteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PacienteDTO atualizar(Integer id, PacienteDTO pacienteDTO) { // falta tratamento para o postman em caso do ID nao existir ainda
        PacienteDTO entity = this.consultarPorId(id);
        pacienteDTO.setId(entity.getId());
        pacienteRepository.saveAndFlush(modelMapper.map(pacienteDTO, Paciente.class));
        return pacienteDTO;
    }

    @Override
    public void excluirPorId(Integer id) { // falta tratamento para o postman em caso do ID nao existir ainda
        consultarPorId(id);
        pacienteRepository.deleteById(id);
    }

}
