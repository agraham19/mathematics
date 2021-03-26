package com.example.mathematics.controllers;

import com.example.mathematics.dto.SieveStepsDto;
import com.example.mathematics.utilities.PrimeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SieveController {
    @GetMapping(value = "/find_primes_up_to/{limit}")
    public SieveStepsDto findPrimesUpTo(@PathVariable int limit) {
        return new SieveStepsDto(PrimeUtils.sieveUpTo(limit));
    }
}
