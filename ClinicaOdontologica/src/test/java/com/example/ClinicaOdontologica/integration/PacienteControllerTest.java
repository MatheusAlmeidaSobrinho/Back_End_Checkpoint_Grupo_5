package com.example.ClinicaOdontologica.integration;

import com.example.ClinicaOdontologica.builder.PacienteBuilder;
import com.example.ClinicaOdontologica.endpoint.PacienteEndpoint;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.security.JwtService;
import common.PacienteMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.example.ClinicaOdontologica.constants.ProfilesConstant.PROFILE_TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile(PROFILE_TEST)
@ActiveProfiles(PROFILE_TEST)
@AutoConfigureMockMvc
class PacienteControllerTest {

    @Autowired
    private JwtService jwtService;

    private final PacienteMock pacienteMock = new PacienteMock();

    @Autowired
    private PacienteEndpoint pacienteEndpoint;

    @Autowired
    private PacienteBuilder pacienteBuilder;

    @Test
    @Order(1)
    void save() throws Exception {
        CredenciaisDTO credenciaisDTO = new CredenciaisDTO();
        credenciaisDTO.setLogin("tawan@gmail.com");
        credenciaisDTO.setSenha("12345678");

        String accessToken = jwtService.gerarToken(credenciaisDTO);

        ResponseEntity<String> dentista = pacienteBuilder.create(accessToken);
        assertEquals(200, dentista.getStatusCodeValue());
    }

    @Test
    @Order(2)
    void listTest() throws Exception {
        CredenciaisDTO credenciaisDTO = new CredenciaisDTO();
        credenciaisDTO.setLogin("tawan@gmail.com");
        credenciaisDTO.setSenha("12345678");

        String accessToken = jwtService.gerarToken(credenciaisDTO);

        ResponseEntity<String> response = pacienteEndpoint.getList(accessToken);
        assertEquals(200, response.getStatusCodeValue());
    }

}
