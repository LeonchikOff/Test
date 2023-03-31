package org.example.service.validation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.Gender;
import org.example.dto.UserForCreateDataTransfer;
import org.example.service.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserForCreateValidator implements Validator<UserForCreateDataTransfer> {
    @Getter
    private static final UserForCreateValidator validator = new UserForCreateValidator();


    @Override
    public ValidationResult validate(UserForCreateDataTransfer userForCreate) {
        ValidationResult validationResult = new ValidationResult();
        if(!LocalDateFormatter.isValid(userForCreate.getDateOfBirth()))
            validationResult.addConstraint(Constraint.of("Invalid date of birth", "Date of Birth is not valid"));
        if(userForCreate.getGender() == null || Gender.valueOf(userForCreate.getGender()) == null) {
            validationResult.addConstraint(Constraint.of("Invalid gender", "Gander is invalid"));
        }
        return validationResult;
    }
}
