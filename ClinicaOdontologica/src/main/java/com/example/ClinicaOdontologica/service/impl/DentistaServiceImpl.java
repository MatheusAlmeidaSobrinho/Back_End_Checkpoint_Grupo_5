package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.common.exception.PasswordInvalidException;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
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
public class DentistaServiceImpl implements IClinicaService<DentistaDTO>, UserDetailsService {

    @Autowired
    private ModelMapper modelMapper;

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
        Dentista dentista = dentistaRepository.findByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String[] roles = new String[] { String.valueOf(dentista.getRoles()) };

      return User
                .builder()
                .username(dentista.getEmail())
                .password(dentista.getSenha())
                .roles(roles)
                .build();

    }

    @Override
    public DentistaDTO cadastrar(DentistaDTO dentistaDTO) {
        String password = bCryptPasswordEncoder.encode(dentistaDTO.getSenha());
        dentistaDTO.setSenha(password);
        Dentista dentista = dentistaRepository.save(modelMapper.map(dentistaDTO, Dentista.class));
        return modelMapper.map(dentista, DentistaDTO.class);
    }

    @Override
    public DentistaDTO consultarPorId(Integer id) {
        Optional<Dentista> dentista = dentistaRepository.findById(id);
        if (dentista.isEmpty()) {
            throw new NotFoundException("Dentista não encontrado!");
        }
        return modelMapper.map(dentista.get(), DentistaDTO.class);
    }

    public List<DentistaDTO> findAll() {
        return dentistaRepository.findAll().stream()
                .map(dentistas -> modelMapper.map(dentistas, DentistaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DentistaDTO atualizar(Integer id, DentistaDTO dentistaDTO) {
        DentistaDTO dentist = consultarPorId(id);
        dentistaDTO.setId(dentist.getId());
        dentistaRepository.saveAndFlush(modelMapper.map(dentistaDTO, Dentista.class));
        return dentistaDTO;
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        dentistaRepository.deleteById(id);
    }

}