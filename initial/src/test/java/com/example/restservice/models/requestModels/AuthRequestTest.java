package com.example.restservice.models.requestModels;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class AuthRequestTest {
    @Test
    public void gettersAndSettersShouldFunctionCorrectly() {
        BeanTester tester = new BeanTester();
        tester.testBean(AuthRequest.class);
    }
}
