package com.example.mathematics.models;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SieveSteps {
    private final List<boolean[]> steps;
    int[] result;

    public SieveSteps(List<boolean[]> steps, int[] result) {
        this.steps = steps;
        this.result = Arrays.copyOf(result, result.length);
    }

    @Override
    public String toString() {
        return steps
                .stream()
                .map(array -> Arrays.toString(array))
                .collect(Collectors.joining("\n")) + "\n" + Arrays.toString(result) + "\n";
    }

}
