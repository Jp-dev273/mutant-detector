package com.jp.mutant.detector.controller.validation.validator;

import com.jp.mutant.detector.controller.validation.annotation.ValidDna;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class DnaValidator implements ConstraintValidator<ValidDna, String[]> {

    private static final Pattern VALID_CHARS = Pattern.compile("^[ATCG]+$");
    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {
        if (dna == null || dna.length == 0){
            return false;
        }
        int amountDnaSequences = dna.length;

        for (String dnaSequences: dna) {
            if (dnaSequences == null){
                return false;
            }
            if (dnaSequences.length() != amountDnaSequences) {
                return false;
            }
            if (!VALID_CHARS.matcher(dnaSequences).matches()){
                return false;
            }
        }
        return true;
    }
}
