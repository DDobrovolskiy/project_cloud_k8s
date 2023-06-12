package ru.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cloud.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String getTest() {
        return testService.getTest();
    }
}
