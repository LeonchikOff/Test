package org.example.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.dao.UserDataAccess;
import org.example.dto.UserDataTransfer;
import org.example.exception.ValidationException;
import org.example.model.entity.User;
import org.example.service.mapper.UserMapper;
import org.example.service.validation.UserDTOValidator;
import org.example.service.validation.ValidationResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    @Getter
    private static final UserService service = new UserService();

    private final UserDTOValidator validator = UserDTOValidator.getValidator();
    private final UserMapper mapper = UserMapper.getUserMapper();
    private final AvatarService avatarService = AvatarService.getAvatarService();
    private final UserDataAccess userDataAccess = UserDataAccess.getDataAccess();


    @SneakyThrows
    public Integer createUserAndGetId(UserDataTransfer userDataTransfer) {
        ValidationResult validationResult = validator.validate(userDataTransfer);
        if (validationResult.isValid()) {
            User user = mapper.mapFrom(userDataTransfer);
            avatarService.upload(user.getAvatar(), userDataTransfer.getAvatar().getInputStream());
            return userDataAccess.save(user).getId();
        } else {
            throw new ValidationException(validationResult.getConstraints());
        }
    }
}
