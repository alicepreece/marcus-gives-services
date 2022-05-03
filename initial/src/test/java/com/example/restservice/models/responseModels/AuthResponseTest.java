package com.example.restservice.models.responseModels;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class AuthResponseTest {
    @Test
    public void gettersAndSettersShouldFunctionCorrectly() {
        BeanTester tester = new BeanTester();
        tester.testBean(AuthResponse.class);
    }
}
