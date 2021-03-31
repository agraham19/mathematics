package com.example.mathematics.utilities;

import com.example.mathematics.models.SieveStep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PrimeUtilsTests {

    List<SieveStep> expected;

    @BeforeEach
    public void beforeEach() {
        expected = List.of(
                new SieveStep(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)),
                new SieveStep(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17), List.of(1), 1),
                new SieveStep(List.of(2, 3, 5, 7, 9, 11, 13, 15, 17), List.of(4, 6, 8, 10, 12, 14, 16), 2),
                new SieveStep(List.of(2, 3, 5, 7, 11, 13, 17), List.of(9, 15), 3),
                new SieveStep(List.of(2, 3, 5, 7, 11, 13, 17), List.of(), 5),
                new SieveStep(List.of(2, 3, 5, 7, 11, 13, 17), List.of(),  7)
        );
    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectResult_97() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(100);
        List<Integer> expected = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        assertEquals(expected, actual.get(actual.size() - 1).getCandidates());
    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectResult_100() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(100);
        List<Integer> expected = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        assertEquals(expected, actual.get(actual.size() - 1).getCandidates());

    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectResult_996() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(996);
        List<Integer> expected = List.of(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
                89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193,
                197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
                317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443,
                449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587,
                593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719,
                727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859,
                863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991
        );

        assertEquals(expected, actual.get(actual.size() - 1).getCandidates());

    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectResult_1000() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(1000);
        List<Integer> expected = List.of(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
                89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193,
                197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
                317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443,
                449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587,
                593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719,
                727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859,
                863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
        );

        assertEquals(expected, actual.get(actual.size() - 1).getCandidates());
    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectPrimesFoSteps_17() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(17);

        IntStream.range(0, actual.size()).forEach(i -> {
            assertEquals(expected.get(i).getCandidates(), actual.get(i).getCandidates());
        });
    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectMultipliersForSteps_17() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(17);

        IntStream.range(0, actual.size()).forEach(i -> {
            assertEquals(expected.get(i).getFilteredMultiplier(), actual.get(i).getFilteredMultiplier());
        });
    }

    @Test
    public void findPrimesUpTo_shouldReturnCorrectFilteredStepsForSteps_17() {
        List<SieveStep> actual = PrimeUtils.sieveUpTo(17);

        IntStream.range(0, actual.size()).forEach(i -> {
            assertEquals(expected.get(i).getFilteredCandidates(), actual.get(i).getFilteredCandidates());
        });
    }
}
