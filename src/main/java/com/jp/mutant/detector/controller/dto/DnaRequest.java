package com.jp.mutant.detector.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jp.mutant.detector.controller.validation.annotation.ValidDna;

@JsonSerialize
public class DnaRequest {
    @ValidDna
    public String[] dna;
}
