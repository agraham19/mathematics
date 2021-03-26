package com.example.mathematics.models;

import lombok.Getter;

import java.util.List;

@Getter
public class SieveSteps {
    private final List<int[]> steps;

    public SieveSteps(List<int[]> steps) {
        this.steps = steps;
    }
}
