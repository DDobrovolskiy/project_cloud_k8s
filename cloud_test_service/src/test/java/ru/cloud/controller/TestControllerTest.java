package ru.cloud.controller;

import org.junit.Assert;
import org.junit.Test;

public class TestControllerTest {

    @Test
    public void getTest() {
        TestController testController = new TestController();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null").append(System.lineSeparator());
        stringBuilder.append("null").append(System.lineSeparator());
        stringBuilder.append("GetTest");
        Assert.assertEquals(testController.getTest(), stringBuilder.toString());
    }
}