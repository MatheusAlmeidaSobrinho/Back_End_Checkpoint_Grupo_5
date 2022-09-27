package com.example.ClinicaOdontologica.unitary;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import com.example.ClinicaOdontologica.service.impl.ConsultaServiceImpl;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import common.ConsultaMock;
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
public class ConsultaServiceTest implements Serializable {

    private final ConsultaMock consultaMock = new ConsultaMock();

    @InjectMocks
    ConsultaServiceImpl consultaService;

    @Mock
    PacienteServiceImpl pacienteService;

    @Mock
    DentistaServiceImpl dentistaService;

    @Mock
    ConsultaRepository consultaRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void saveConsultaSuccessTest() {
        ConsultaDTO request = consultaMock.getConsultaRequestDTO();
        Consulta response = consultaMock.getConsultaWithId();

        when(consultaRepository.save(any(Consulta.class))).thenReturn(response);

        ConsultaDTO consulta = consultaService.cadastrar(request);

        assertNotEquals(0, response.getId());
        assertEquals(consulta.getPacienteId(), response.getPaciente().getId());
        assertEquals(consulta.getDentistaId(), response.getDentista().getId());
        assertEquals(consulta.getData(), response.getData());
    }

    @Test
    @Order(2)
    void listConsultaTest() {
        List<Consulta> consultas = consultaMock.getList();
        when(consultaRepository.findAll()).thenReturn(consultas);

        List<ConsultaDTO> consultaDTOList = consultaService.findAll();

        for (int i = 0; i < consultas.size(); i++) {
            assertEquals(consultaDTOList.get(i).getPacienteId(), consultas.get(i).getPaciente().getId());
            assertEquals(consultaDTOList.get(i).getDentistaId(), consultas.get(i).getDentista().getId());
            assertEquals(consultaDTOList.get(i).getData(), consultas.get(i).getData());
        }
    }

    @Test
    @Order(3)
    void getDentistaByIdTest() {
        Consulta consulta = consultaMock.getConsultaWithId();
        when(consultaRepository.findById(99999)).thenReturn(Optional.ofNullable(consulta));
        assert consulta != null;
        ConsultaDTO consultaFound = consultaService.consultarPorId(consulta.getId());
        assertEquals(consulta.getId(), consultaFound.getId());
        assertEquals(consulta.getPaciente().getId(), consultaFound.getPacienteId());
        assertEquals(consulta.getDentista().getId(), consultaFound.getDentistaId());
        assertEquals(consulta.getData(), consultaFound.getData());
    }

}
