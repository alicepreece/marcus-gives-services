package com.example.restservice.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserTest {

    @Test
    public void gettersAndSettersShouldFunctionCorrectly() {
        BeanTester tester = new BeanTester();
        tester.testBean(User.class);
    }
}
