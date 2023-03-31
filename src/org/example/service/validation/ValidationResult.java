package org.example.service.validation;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    @Getter
    private final List<Constraint> constraints = new ArrayList<>();

    public boolean isValid() {
        return constraints.isEmpty();
    }

    public void addConstraint(Constraint constraint) {
        constraints.add(constraint);
    }

}
