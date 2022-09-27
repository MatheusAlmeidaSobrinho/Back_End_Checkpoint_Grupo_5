package com.example.ClinicaOdontologica.unitary;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.service.impl.EnderecoServiceImpl;
import common.EnderecoMock;
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
public class EnderecoServiceTest implements Serializable {

    private final EnderecoMock enderecoMock = new EnderecoMock();

    @InjectMocks
    EnderecoServiceImpl enderecoService;

    @Mock
    EnderecoRepository enderecoRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void saveDentistaSuccessTest() {
        EnderecoDTO request = enderecoMock.getEnderecoRequestDTO();
        Endereco response = enderecoMock.getEnderecoWithId();

        when(enderecoRepository.save(any(Endereco.class))).thenReturn(response);

        EnderecoDTO dentista = enderecoService.cadastrar(request);

        assertNotEquals(0, response.getId());
        assertEquals(dentista.getRua(), response.getRua());
        assertEquals(dentista.getNumero(), response.getNumero());
        assertEquals(dentista.getCidade(), response.getCidade());
        assertEquals(dentista.getBairro(), response.getBairro());
        assertEquals(dentista.getCep(), response.getCep());
    }

    @Test
    @Order(2)
    void listDentistaTest() {
        List<Endereco> enderecos = enderecoMock.getList();
        when(enderecoRepository.findAll()).thenReturn(enderecos);

        List<EnderecoDTO> enderecoDTOList = enderecoService.findAll();

        for (int i = 0; i < enderecos.size(); i++) {
            assertEquals(enderecoDTOList.get(i).getRua(), enderecos.get(i).getRua());
            assertEquals(enderecoDTOList.get(i).getNumero(), enderecos.get(i).getNumero());
            assertEquals(enderecoDTOList.get(i).getCidade(), enderecos.get(i).getCidade());
            assertEquals(enderecoDTOList.get(i).getBairro(), enderecos.get(i).getBairro());
            assertEquals(enderecoDTOList.get(i).getCep(), enderecos.get(i).getCep());
        }
    }

    @Test
    @Order(3)
    void getDentistaByIdTest() {
        Endereco enderecoWithId = enderecoMock.getEnderecoWithId();
        when(enderecoRepository.findById(99999)).thenReturn(Optional.ofNullable(enderecoWithId));
        assert enderecoWithId != null;
        EnderecoDTO enderecoDTO = enderecoService.consultarPorId(enderecoWithId.getId());

        assertNotEquals(0, enderecoDTO.getId());
        assertEquals(enderecoWithId.getRua(), enderecoDTO.getRua());
        assertEquals(enderecoWithId.getNumero(), enderecoDTO.getNumero());
        assertEquals(enderecoWithId.getCidade(), enderecoDTO.getCidade());
        assertEquals(enderecoWithId.getBairro(), enderecoDTO.getBairro());
        assertEquals(enderecoWithId.getCep(), enderecoDTO.getCep());
    }

}
