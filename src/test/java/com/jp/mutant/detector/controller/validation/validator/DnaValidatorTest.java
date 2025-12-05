package com.jp.mutant.detector.controller.validation.validator;

import com.jp.mutant.detector.controller.validation.annotation.ValidDna;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DnaValidatorTest {

    private final Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    private static class TestDto {
        @ValidDna
        String[] dna;

        TestDto(String[] dna){
            this.dna = dna;
        }
    }

    @Test
    @DisplayName("Given an array n size with string n length Should return valid")
    void isValid() {
        String[] dna = {"ATCG", "TCGA", "CGAT", "GATC"};

        Set<ConstraintViolation<TestDto>> violations = validator.validate(new TestDto(dna));

        assertTrue(violations.isEmpty());

    }

    @Test
    @DisplayName("Given an empty array or null array Should return false")
    void emptyArray(){
        Set<ConstraintViolation<TestDto>> violationsNullArray = validator.validate(new TestDto(null));
        assertFalse(violationsNullArray.isEmpty());

        Set<ConstraintViolation<TestDto>> violationsEmptyArray = validator.validate(new TestDto(new String[]{}));
        assertFalse(violationsEmptyArray.isEmpty());
    }

    @Test
    @DisplayName("Given an empty string or null string Should return false")
    void emptyStringInArray(){

        String[] dnaWithEmptyString = {"ATCG", "TCGA", "CGAT", ""};
        Set<ConstraintViolation<TestDto>> emptyStringViolations = validator.validate(new TestDto(dnaWithEmptyString));
        assertFalse(emptyStringViolations.isEmpty());

        String[] dnaWithNullString = {"ATCG", "TCGA", null , "GATC"};
        Set<ConstraintViolation<TestDto>> nullStringViolations = validator.validate(new TestDto(dnaWithNullString));
        assertFalse(nullStringViolations.isEmpty());
    }

    @Test
    @DisplayName("Given an array n size with a string m length Should return false")
    void notSquareMatrix(){
        String[] dna = {"ATCG", "TCA", "CGAT", "GATC"};

        Set<ConstraintViolation<TestDto>> violations = validator.validate(new TestDto(dna));

        assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("Given a string with a different character allowed Should return false")
    void notAllowedCharInArray(){
        String[] dna = {"ATCX", "TCGA", "CGAT", "GATC"};

        Set<ConstraintViolation<TestDto>> violations = validator.validate(new TestDto(dna));

        assertFalse(violations.isEmpty());
    }
}