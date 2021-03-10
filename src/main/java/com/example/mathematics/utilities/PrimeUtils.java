package com.example.mathematics.utilities;

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
    public static int[] findPrimesUpTo(int upper) {
        boolean[] isPrime = new boolean[upper + 1];
        Arrays.fill(isPrime, Boolean.TRUE);

        for(int i = 2; i <= Math.sqrt(upper); i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= upper; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        return IntStream.rangeClosed(2, upper).filter(i -> isPrime[i]).toArray();
    }
}
