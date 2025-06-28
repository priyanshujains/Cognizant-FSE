package org.example;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        //  Checks if the two values are equal
        assertEquals(5, 2 + 3);

        //  Checks if the condition is true
        assertTrue(5 > 3);

        //  Checks if the condition is false
        assertFalse(5 < 3);

        //  Checks if the object is null
        assertNull(null);

        //  Checks if the object is NOT null
        assertNotNull(new Object());
    }
}
