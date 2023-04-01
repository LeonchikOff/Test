package org.example.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.dao.UserDataAccess;
import org.example.dto.CreateUserTransfer;
import org.example.dto.ReadUserTransfer;
import org.example.exception.ValidationException;
import org.example.model.entity.User;
import org.example.service.mapper.CreatableUserMapper;
import org.example.service.mapper.ReadableUserMapper;
import org.example.service.validation.UserDTOValidator;
import org.example.service.validation.ValidationResult;

import java.util.Optional;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    @Getter
    private static final UserService service = new UserService();

    private final UserDTOValidator validator = UserDTOValidator.getValidator();
    private final CreatableUserMapper creatableUserMapper = CreatableUserMapper.getCreatableUserMapper();
    private final ReadableUserMapper readableUserMapper = ReadableUserMapper.getReadableUserMapper();
    private final AvatarService avatarService = AvatarService.getAvatarService();
    private final UserDataAccess userDataAccess = UserDataAccess.getDataAccess();


    public Optional<ReadUserTransfer> login(String email, String password) {
        return  userDataAccess.findByEmailAndPassword(email, password).map(readableUserMapper::mapFrom);
    }

    @SneakyThrows
    public Integer createUserAndGetId(CreateUserTransfer createUserTransfer) {
        ValidationResult validationResult = validator.validate(createUserTransfer);
        if (validationResult.isValid()) {
            User user = creatableUserMapper.mapFrom(createUserTransfer);
            avatarService.upload(user.getAvatar(), createUserTransfer.getAvatar().getInputStream());
            return userDataAccess.save(user).getId();
        } else {
            throw new ValidationException(validationResult.getConstraints());
        }
    }
}
