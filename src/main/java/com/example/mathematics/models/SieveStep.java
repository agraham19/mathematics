package com.example.mathematics.models;

import lombok.Getter;

import java.util.List;

@Getter
public class SieveStep {
    private List<Integer> candidates;
    private List<Integer> filteredCandidates;
    private Integer filteredMultiplier; // the multiplier filtered out in this step

    public SieveStep(List<Integer> candidates, List<Integer> filteredCandidates, int filteredMultiplier) {
        this.filteredMultiplier = filteredMultiplier;
        this.filteredCandidates = filteredCandidates;
        this.candidates = candidates;
    }

    public SieveStep(List<Integer> candidates) {
        this.candidates = candidates;
    }
}
