package com.example.mathematics.dto;

import com.example.mathematics.models.SieveSteps;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SieveStepsDto {
    @JsonProperty("steps")
    private final List<boolean[]> steps;

    @JsonProperty("result")
    private final int[] result;

    public SieveStepsDto(SieveSteps sieveSteps) {
        this.steps = sieveSteps.getSteps();
        this.result = sieveSteps.getResult();
    }
}
