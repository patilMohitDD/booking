package com.showstopper.booking.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class CustomValidator {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public <T> Set<ConstraintViolation<T>> validate(T type){
        return validator.validate(type);
    }
}
