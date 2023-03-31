package org.example.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dao.UserDataAccess;
import org.example.model.entity.User;
import org.example.dto.UserForCreateDataTransfer;
import org.example.service.mapper.UserForCreateMapper;
import org.example.service.validation.UserForCreateValidator;
import org.example.service.validation.ValidationResult;
import org.example.exception.ValidationException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    @Getter
    private static final UserService service = new UserService();

    private final UserForCreateValidator validator = UserForCreateValidator.getValidator();
    private final UserForCreateMapper mapper = UserForCreateMapper.getUserForCreateMapper();
    private final UserDataAccess userDataAccess = UserDataAccess.getDataAccess();


    public Integer createUserAndGetId(UserForCreateDataTransfer userForCreateDataTransfer) {
        ValidationResult validationResult = validator.validate(userForCreateDataTransfer);
        if (validationResult.isValid()) {
            User user = mapper.mapFrom(userForCreateDataTransfer);
            return userDataAccess.save(user).getId();
        } else {
            throw new ValidationException(validationResult.getConstraints());
        }
    }
}
