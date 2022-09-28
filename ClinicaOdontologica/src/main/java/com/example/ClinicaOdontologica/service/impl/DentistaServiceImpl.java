package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.common.exception.PasswordInvalidException;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
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
public class DentistaServiceImpl implements IClinicaService<DentistaDTO>, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DentistaRepository dentistaRepository;

    public UserDetails autenticar(CredenciaisDTO credenciais) {
        System.out.println("Credentials recebidas" + credenciais);
        UserDetails user = loadUserByUsername(credenciais.getLogin());
        System.out.println("Usuário do banco " + user);
        boolean senhasIguais = bCryptPasswordEncoder.matches(credenciais.getSenha(), user.getPassword());

        if (senhasIguais) {
            return user;
        }
        throw new PasswordInvalidException("Senha inválida.");
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Dentista> dentista = dentistaRepository.findByEmail(login);

                if (dentista.isPresent()) {
                    String[] roles = new String[]{String.valueOf(dentista.get().getRoles())};

                    return User
                            .builder()
                            .username(dentista.get().getEmail())
                            .password(dentista.get().getSenha())
                            .roles(roles)
                            .build();
                }

        return null;
    }

    @Override
    public DentistaDTO cadastrar(DentistaDTO dentistaDTO) {
        String password = bCryptPasswordEncoder.encode(dentistaDTO.getSenha());
        dentistaDTO.setSenha(password);
        Dentista dentista = dentistaRepository.save(convertDentistaDTOIntoDentista(dentistaDTO));
        return convertDentistaIntoDentistaDTO(dentista);
    }

    @Override
    public DentistaDTO consultarPorId(Integer id) {
        Optional<Dentista> dentistaById = dentistaRepository.findById(id);
        if (dentistaById.isEmpty()) {
            throw new NotFoundException("Dentista não encontrado!");
        }
        return convertDentistaIntoDentistaDTO(dentistaById.get());
    }

    public List<DentistaDTO> findAll() {
        return dentistaRepository.findAll().stream()
                .map(this::convertDentistaIntoDentistaDTO).collect(Collectors.toList());
    }

    @Override
    public DentistaDTO atualizar(Integer id, DentistaDTO dentistaDTO) {
        DentistaDTO dentistaById = consultarPorId(id);
        dentistaDTO.setId(dentistaById.getId());

        Dentista dentista = convertDentistaDTOIntoDentista(dentistaDTO);
        Dentista dentistaSaved = dentistaRepository.saveAndFlush(dentista);
        return convertDentistaIntoDentistaDTO(dentistaSaved);
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        dentistaRepository.deleteById(id);
    }

    public Dentista convertDentistaDTOIntoDentista(DentistaDTO dentistaDTO) {
        return Dentista.builder()
                .id(dentistaDTO.getId())
                .nome(dentistaDTO.getNome())
                .sobrenome(dentistaDTO.getSobrenome())
                .email(dentistaDTO.getEmail())
                .senha(dentistaDTO.getSenha())
                .cro(dentistaDTO.getCro())
                .matricula(dentistaDTO.getMatricula())
                .roles(dentistaDTO.getRoles())
                .build();
    }

    private DentistaDTO convertDentistaIntoDentistaDTO(Dentista dentista) {
        return DentistaDTO.builder()
                .id(dentista.getId())
                .nome(dentista.getNome())
                .sobrenome(dentista.getSobrenome())
                .email(dentista.getEmail())
                .senha(dentista.getSenha())
                .cro(dentista.getCro()).
                matricula(dentista.getMatricula())
                .roles(dentista.getRoles())
                .build();
    }
}