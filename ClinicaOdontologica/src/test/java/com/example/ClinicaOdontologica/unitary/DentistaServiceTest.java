package com.example.ClinicaOdontologica.unitary;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import common.DentistaMock;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DentistaServiceTest implements Serializable {

    @Autowired
    private ModelMapper modelMapper;

    private final DentistaMock dentistaMock = new DentistaMock();

    @InjectMocks
    DentistaServiceImpl dentistaService;

    @Mock
    DentistaRepository dentistaRepository;

    @Mock
    EntityManager entityManager;



    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void saveDentistaSuccessTest(){
        DentistaDTO request = dentistaMock.getDentistaRequestDTO();
        Dentista response = dentistaMock.getDentistaWithId();

        when(dentistaRepository.save(any(Dentista.class))).thenReturn(response);

        DentistaDTO dentista = dentistaService.cadastrar(request);

        assertNotEquals(0, response.getId());
        assertEquals(dentista.getNome(), response.getNome());
    }

}
