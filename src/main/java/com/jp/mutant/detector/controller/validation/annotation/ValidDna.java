package com.jp.mutant.detector.controller.validation.annotation;

import com.jp.mutant.detector.controller.validation.validator.DnaValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DnaValidator.class)
public @interface ValidDna {
    String message() default "Invalid Dna";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
