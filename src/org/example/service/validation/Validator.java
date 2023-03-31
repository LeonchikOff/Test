package org.example.service.validation;

public interface Validator<T> {
    ValidationResult validate(T object);
}
