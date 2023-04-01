package org.example.service.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.Gender;
import org.example.model.Role;
import org.example.model.entity.User;
import org.example.dto.UserDataTransfer;
import org.example.service.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<UserDataTransfer, User> {
    @Getter
    private static final UserMapper userMapper = new UserMapper();
    private static final String AVATAR_FOLDER = "avatars/";


    @Override
    public User mapFrom(UserDataTransfer userDataTransfer) {
        return User.builder()
                .avatar(AVATAR_FOLDER + userDataTransfer.getAvatar().getSubmittedFileName())
                .name(userDataTransfer.getName())
                .dateOfBirth(LocalDateFormatter.format(userDataTransfer.getDateOfBirth()))
                .email(userDataTransfer.getEmail())
                .password(userDataTransfer.getPassword())
                .role(Role.valueOf(userDataTransfer.getRole()))
                .gender(Gender.valueOf(userDataTransfer.getGender()))
                .build();
    }
}
