package com.example.mathematics.dto;

import com.example.mathematics.models.SieveSteps;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SieveStepsDto {
    @JsonProperty("steps")
    private final List<int[]> steps;

    public SieveStepsDto(SieveSteps steps) {
        this.steps = steps.getSteps();
    }
}
