package com.example.ClinicaOdontologica.integration;

import com.example.ClinicaOdontologica.builder.EnderecoBuilder;
import com.example.ClinicaOdontologica.endpoint.EnderecoEndpoint;
import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.security.JwtService;
import common.EnderecoMock;
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
class EnderecoControllerTest {

    @Autowired
    private JwtService jwtService;

    private final EnderecoMock enderecoMock = new EnderecoMock();
    @Autowired
    private EnderecoEndpoint enderecoEndpoint;

    @Autowired
    private EnderecoBuilder enderecoBuilder;

    @Test
    @Order(1)
    void save() throws Exception {
        CredenciaisDTO credenciaisDTO = new CredenciaisDTO();
        credenciaisDTO.setLogin("tawan@gmail.com");
        credenciaisDTO.setSenha("12345678");

        String accessToken = jwtService.gerarToken(credenciaisDTO);

        ResponseEntity<String> endereco = enderecoBuilder.create(accessToken);
        assertEquals(200, endereco.getStatusCodeValue());
    }

    @Test
    @Order(2)
    void listTest() throws Exception {
        CredenciaisDTO credenciaisDTO = new CredenciaisDTO();
        credenciaisDTO.setLogin("tawan@gmail.com");
        credenciaisDTO.setSenha("12345678");

        String accessToken = jwtService.gerarToken(credenciaisDTO);

        ResponseEntity<String> response = enderecoEndpoint.getList(accessToken);
        assertEquals(200, response.getStatusCodeValue());
    }

}
