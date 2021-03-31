package com.example.mathematics.dto;

import com.example.mathematics.models.SieveStep;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SieveStepsDto {
    @JsonProperty("steps")
    private final List<SieveStepDto> steps;

    public SieveStepsDto(List<SieveStep> steps) {
        this.steps = steps.stream().map(SieveStepDto::new).collect(Collectors.toList());
    }
}
