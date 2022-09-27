package com.example.ClinicaOdontologica.unitary;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import common.DentistaMock;
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
public class DentistaServiceTest implements Serializable {

    private final DentistaMock dentistaMock = new DentistaMock();

    @InjectMocks
    DentistaServiceImpl dentistaService;

    @Mock
    DentistaRepository dentistaRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void saveDentistaSuccessTest() {
        DentistaDTO request = dentistaMock.getDentistaRequestDTO();
        Dentista response = dentistaMock.getDentistaWithId();

        when(dentistaRepository.save(any(Dentista.class))).thenReturn(response);

        DentistaDTO dentista = dentistaService.cadastrar(request);

        assertNotEquals(0, response.getId());
        assertEquals(dentista.getNome(), response.getNome());
        assertEquals(dentista.getSobrenome(), response.getSobrenome());
        assertEquals(dentista.getEmail(), response.getEmail());
        assertEquals(dentista.getSenha(), response.getSenha());
        assertEquals(dentista.getRoles(), response.getRoles());
        assertEquals(dentista.getCro(), response.getCro());
        assertEquals(dentista.getMatricula(), response.getMatricula());
    }

    @Test
    @Order(2)
    void listDentistaTest() {
        List<Dentista> dentistaList = dentistaMock.getList();
        when(dentistaRepository.findAll()).thenReturn(dentistaList);

        List<DentistaDTO> dentista = dentistaService.findAll();

        for (int i = 0; i < dentistaList.size(); i++) {
            assertEquals(dentistaList.get(i).getNome(), dentista.get(i).getNome());
            assertEquals(dentistaList.get(i).getSobrenome(), dentista.get(i).getSobrenome());
            assertEquals(dentistaList.get(i).getEmail(), dentista.get(i).getEmail());
            assertEquals(dentistaList.get(i).getSenha(), dentista.get(i).getSenha());
            assertEquals(dentistaList.get(i).getRoles(), dentista.get(i).getRoles());
            assertEquals(dentistaList.get(i).getCro(), dentista.get(i).getCro());
            assertEquals(dentistaList.get(i).getMatricula(), dentista.get(i).getMatricula());
        }
    }

    @Test
    @Order(3)
    void getDentistaByIdTest() {
        Dentista dentista = dentistaMock.getDentistaWithId();

        when(dentistaRepository.findById(99999)).thenReturn(Optional.ofNullable(dentista));

        assert dentista != null;
        DentistaDTO dentistaFound = dentistaService.consultarPorId(dentista.getId());

        assertEquals(dentista.getId(), dentistaFound.getId());
        assertEquals(dentista.getNome(), dentistaFound.getNome());
        assertEquals(dentista.getSobrenome(), dentistaFound.getSobrenome());
        assertEquals(dentista.getEmail(), dentistaFound.getEmail());
        assertEquals(dentista.getSenha(), dentistaFound.getSenha());
        assertEquals(dentista.getRoles(), dentistaFound.getRoles());
        assertEquals(dentista.getCro(), dentistaFound.getCro());
        assertEquals(dentista.getMatricula(), dentistaFound.getMatricula());
    }

}
