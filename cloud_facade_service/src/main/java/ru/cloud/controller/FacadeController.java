package ru.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacadeController {
    @GetMapping
    public String getFacade() {
        return "GetFacade";
    }
}
