package com.example.mathematics.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class PrimeUtilsTests {

    @Test
    public void findPrimesInRange_shouldReturnCorrectValues() {
        int[] actual = PrimeUtils.findPrimesUpTo(100);
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        assertArrayEquals(expected, actual);
    }
}
