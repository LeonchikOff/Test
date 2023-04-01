package org.example.service.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dto.CreateUserTransfer;
import org.example.model.Gender;
import org.example.model.Role;
import org.example.model.entity.User;
import org.example.service.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatableUserMapper implements Mapper<CreateUserTransfer, User> {
    @Getter
    private static final CreatableUserMapper creatableUserMapper = new CreatableUserMapper();
    private static final String AVATAR_FOLDER = "avatars/";


    @Override
    public User mapFrom(CreateUserTransfer createUserTransfer) {
        return User.builder()
                .avatar(AVATAR_FOLDER + createUserTransfer.getAvatar().getSubmittedFileName())
                .name(createUserTransfer.getName())
                .dateOfBirth(LocalDateFormatter.format(createUserTransfer.getDateOfBirth()))
                .email(createUserTransfer.getEmail())
                .password(createUserTransfer.getPassword())
                .role(Role.valueOf(createUserTransfer.getRole()))
                .gender(Gender.valueOf(createUserTransfer.getGender()))
                .build();
    }

}
