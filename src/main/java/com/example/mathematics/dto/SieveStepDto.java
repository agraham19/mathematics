package com.example.mathematics.dto;

import com.example.mathematics.models.SieveStep;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SieveStepDto {
    @JsonProperty("remainingCandidates")
    private final List<Integer> remainingCandidates;

    @JsonProperty("filteredCandidates")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Integer> filteredCandidates;

    @JsonProperty("filteredMultiplier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer filteredMultiplier; // the multiplier filtered out in this step

    public SieveStepDto(SieveStep sieveStep) {
        this.remainingCandidates = sieveStep.getCandidates();
        this.filteredCandidates = sieveStep.getFilteredCandidates();
        this.filteredMultiplier = sieveStep.getFilteredMultiplier();
    }
}
