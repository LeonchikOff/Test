package org.example.model;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MALE, FEMALE;

    public static Optional<Gender> byName(String gender) {
        return Arrays.stream(values()).filter(it -> it.name().equals(gender)).findFirst();
    }
}
