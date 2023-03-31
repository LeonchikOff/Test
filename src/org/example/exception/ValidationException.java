package org.example.exception;

import lombok.Getter;
import org.example.service.validation.Constraint;

import java.util.List;

public class ValidationException extends RuntimeException {
    @Getter
    private final List<Constraint> constraints;

    public ValidationException(List<Constraint> constraints) {
        this.constraints = constraints;
    }
}
