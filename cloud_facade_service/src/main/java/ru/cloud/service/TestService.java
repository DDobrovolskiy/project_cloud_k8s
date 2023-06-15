package ru.cloud.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Log4j2
public class TestService {
    @Value("${instance.test}")
    private String nameTestService;
    @Autowired
    private RestTemplate restTemplate;

    public String getTest() {
        log.info("GetFacadeTest: " + nameTestService);
        URI uri = URI.create(nameTestService);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return response.getBody();
    }
}
