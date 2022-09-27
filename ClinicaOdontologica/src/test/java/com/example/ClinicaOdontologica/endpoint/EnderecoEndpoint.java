package com.example.ClinicaOdontologica.endpoint;

import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class EnderecoEndpoint {

    private final static String url = "http://localhost:8080/enderecos";

    @Autowired
    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    private static RestTemplate restTemplate;

    public ResponseEntity<String> save(EnderecoDTO requestDTO, String accessToken) throws Exception {
        HttpHeaders headers = getHeaderWithBearerToken(accessToken);

        RequestEntity<EnderecoDTO> requestEntity = RequestEntity
                .post(new URI(url))
                .headers(headers)
                .body(requestDTO);
        return testRestTemplate.exchange(requestEntity, String.class);
    }

    public ResponseEntity<String> getList(String accessToken) throws Exception {
        HttpHeaders headers = getHeaderWithBearerToken(accessToken);

        RequestEntity<Void> requestEntity = RequestEntity
                .get(new URI(url))
                .headers(headers)
                .build();
        return testRestTemplate.exchange(requestEntity, String.class);
    }


    @NotNull
    private HttpHeaders getHeaderWithBearerToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return headers;
    }

}
