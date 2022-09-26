package com.example.ClinicaOdontologica.endpoint;

import com.example.ClinicaOdontologica.entity.dto.CredenciaisDTO;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class DentistaEndpoint {

    @LocalServerPort
    private Integer port;

    private static String url = "http://localhost:";

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    private static RestTemplate restTemplate;

    public ResponseEntity<String> save(DentistaDTO requestDTO, String accessToken) throws Exception {
        HttpHeaders headers = getHeaderWithBearerToken(accessToken);

        RequestEntity<DentistaDTO> requestEntity = RequestEntity
                .post(new URI(url.concat(port+"").concat("/dentistas")))
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
