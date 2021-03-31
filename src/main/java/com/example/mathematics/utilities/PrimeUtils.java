package com.example.mathematics.utilities;

import com.example.mathematics.models.SieveStep;

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
    public static List<SieveStep> sieveUpTo(int upper) {
        boolean[] isPrime = new boolean[upper + 1];
        Arrays.fill(isPrime, Boolean.TRUE);

        List<SieveStep> steps = new ArrayList<>();

        int squareRootOfUpperRoundedUp = (int) Math.ceil(Math.sqrt(upper));

        isPrime[0] = false;

        steps.add(new SieveStep(candidateBooleansToInts(isPrime))); // add first step

        isPrime[1] = false;

        steps.add(new SieveStep(candidateBooleansToInts(isPrime), List.of(1), 1)); // add second step

        IntStream.rangeClosed(2, squareRootOfUpperRoundedUp).forEach(i -> {
            if(isPrime[i]) {
                ArrayList filtered = new ArrayList();

                IntStream.iterate(i * i, current -> current <= upper, next -> next + i)
                        .parallel().forEach((current -> {
                            if (isPrime[current]) {
                                filtered.add(current);
                            }
                            isPrime[current] = false;
                }));

                steps.add(new SieveStep(candidateBooleansToInts(isPrime), filtered, i)); // add step
            }
        });

        return steps;
    }

    public static List<Integer> candidateBooleansToInts(boolean[] candidates) {
        return IntStream.rangeClosed(1, candidates.length - 1)
                .filter(i -> candidates[i]).boxed().collect(Collectors.toList());
    }
}
