package org.example.service.validation;

import lombok.Value;

@Value(staticConstructor = "of")
public class Constraint {
    String code;
    String massage;
}
