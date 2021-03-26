package com.example.mathematics.utilities;

import com.example.mathematics.models.SieveSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeUtils {

    /**
     * Sieve of Eratosthenes
     *
     * Finds all primes in a given range, up to and including the upper bound
     *
     * @param upper The upper bound
     * @return an array of all primes lesser than or equal to the upper bound
     */
    public static SieveSteps sieveUpTo(int upper) {
        boolean[] isPrime = new boolean[upper + 1];
        Arrays.fill(isPrime, Boolean.TRUE);

        isPrime[0] = isPrime[1] = false;

        List<boolean[]> steps = new ArrayList<>();

        int squareRootOfUpperRoundedUp = (int) Math.ceil(Math.sqrt(upper));

        steps.add(Arrays.copyOf(isPrime, isPrime.length)); // add first step

        IntStream.rangeClosed(2, squareRootOfUpperRoundedUp).forEach(i -> {
            if(isPrime[i]) {
                IntStream.iterate(i * i, current -> current <= upper, next -> next + i)
                        .parallel().forEach((current -> isPrime[current] = false));
            }

            steps.add(Arrays.copyOf(isPrime, isPrime.length)); // add step
        });

        return new SieveSteps(steps.stream()
                .map(step -> IntStream.rangeClosed(2, step.length - 1).filter(i -> step[i]).toArray())
                .collect(Collectors.toList()));
    }
}
