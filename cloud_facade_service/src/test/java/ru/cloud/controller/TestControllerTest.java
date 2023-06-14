package ru.cloud.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestControllerTest {
    @Test
    public void testGetFacade() {
        FacadeController facadeController = new FacadeController();
        assertEquals(facadeController.getFacade(), "GetFacade");
    }
}