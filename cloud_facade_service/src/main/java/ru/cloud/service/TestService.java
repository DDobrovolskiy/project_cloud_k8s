package ru.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class TestService {
    @Value("${instance.test}")
    private String nameTestService;
    @Autowired
    private RestTemplate restTemplate;

    public String getTest() {
        URI uri = URI.create(nameTestService);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return response.getBody();
    }
}
