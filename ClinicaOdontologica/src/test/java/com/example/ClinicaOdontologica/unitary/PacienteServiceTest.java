package com.example.ClinicaOdontologica.unitary;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.impl.EnderecoServiceImpl;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import common.PacienteMock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest implements Serializable {

    private final PacienteMock pacienteMock = new PacienteMock();

    @InjectMocks
    PacienteServiceImpl pacienteService;

    @Mock
    EnderecoServiceImpl enderecoService;

    @Mock
    PacienteRepository pacienteRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void saveDentistaSuccessTest() {
        PacienteDTO request = pacienteMock.getPacienteRequestDTO();
        Paciente response = pacienteMock.getPacienteWithId();

        when(pacienteRepository.save(any(Paciente.class))).thenReturn(response);

        PacienteDTO paciente = pacienteService.cadastrar(request);

        assertNotEquals(0, response.getId());
        assertEquals(paciente.getNome(), response.getNome());
        assertEquals(paciente.getSobrenome(), response.getSobrenome());
        assertEquals(paciente.getEmail(), response.getEmail());
        assertEquals(paciente.getSenha(), response.getSenha());
        assertEquals(paciente.getDataDeAlta(), response.getDataDeAlta());
        assertEquals(paciente.getEnderecoId(), response.getEndereco().getId());
        assertEquals(paciente.getRg(), response.getRg());
        assertEquals(paciente.getRoles(), response.getRoles());
    }

    @Test
    @Order(2)
    void listDentistaTest() {
        List<Paciente> pacientes = pacienteMock.getList();
        when(pacienteRepository.findAll()).thenReturn(pacientes);

        List<PacienteDTO> pacienteDTOList = pacienteService.findAll();

        for (int i = 0; i < pacientes.size(); i++) {
            assertEquals(pacienteDTOList.get(i).getNome(), pacientes.get(i).getNome());
            assertEquals(pacienteDTOList.get(i).getSobrenome(), pacientes.get(i).getSobrenome());
            assertEquals(pacienteDTOList.get(i).getEmail(), pacientes.get(i).getEmail());
            assertEquals(pacienteDTOList.get(i).getSenha(), pacientes.get(i).getSenha());
            assertEquals(pacienteDTOList.get(i).getDataDeAlta(), pacientes.get(i).getDataDeAlta());
            assertEquals(pacienteDTOList.get(i).getEnderecoId(), pacientes.get(i).getEndereco().getId());
            assertEquals(pacienteDTOList.get(i).getRg(), pacientes.get(i).getRg());
            assertEquals(pacienteDTOList.get(i).getRoles(), pacientes.get(i).getRoles());
        }
    }

    @Test
    @Order(3)
    void getDentistaByIdTest() {
        Paciente paciente = pacienteMock.getPacienteWithId();
        when(pacienteRepository.findById(99999)).thenReturn(Optional.ofNullable(paciente));
        assert paciente != null;
        PacienteDTO pacienteDTO = pacienteService.consultarPorId(paciente.getId());

        assertEquals(paciente.getId(), pacienteDTO.getId());
        assertEquals(paciente.getNome(), pacienteDTO.getNome());
        assertEquals(paciente.getSobrenome(), pacienteDTO.getSobrenome());
        assertEquals(paciente.getEmail(), pacienteDTO.getEmail());
        assertEquals(paciente.getSenha(), pacienteDTO.getSenha());
        assertEquals(paciente.getDataDeAlta(), pacienteDTO.getDataDeAlta());
        assertEquals(paciente.getEndereco().getId(), pacienteDTO.getEnderecoId());
        assertEquals(paciente.getRg(), pacienteDTO.getRg());
        assertEquals(paciente.getRoles(), pacienteDTO.getRoles());
    }

}
