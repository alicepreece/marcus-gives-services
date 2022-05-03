package com.example.restservice.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class ProjectTest {
    @Test
    public void gettersAndSettersShouldFunctionCorrectly() {
        BeanTester tester = new BeanTester();
        tester.testBean(Project.class);
    }
}
