package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator; // Shared test object

    // This runs before EACH test
    @Before
    public void setUp() {
        calculator = new Calculator(); // Arrange: setup Calculator
        System.out.println("Setup: Calculator instance created");
    }

    // This runs after EACH test
    @After
    public void tearDown() {
        calculator = null; // Cleanup
        System.out.println("Teardown: Calculator instance cleared");
    }

    // Test using AAA pattern
    @Test
    public void testAddition() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    // Another test
    @Test
    public void testMultiplication() {
        // Arrange
        int a = 4, b = 3;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }
}
