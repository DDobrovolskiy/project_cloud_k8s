package ru.cloud.controller;

import org.junit.Assert;
import org.junit.Test;

public class TestControllerTest {

    @Test
    public void getTest() {
        TestController testController = new TestController();
        Assert.assertEquals(testController.getTest(), "GetTest");
    }
}