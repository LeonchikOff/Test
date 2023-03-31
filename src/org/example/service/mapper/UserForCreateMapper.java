package org.example.service.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.Gender;
import org.example.model.Role;
import org.example.model.entity.User;
import org.example.dto.UserForCreateDataTransfer;
import org.example.service.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserForCreateMapper implements Mapper<UserForCreateDataTransfer, User> {
    @Getter
    private static final UserForCreateMapper userForCreateMapper = new UserForCreateMapper();

    @Override
    public User mapFrom(UserForCreateDataTransfer userForCreateDataTransfer) {
        return User.builder()
                .name(userForCreateDataTransfer.getName())
                .dateOfBirth(LocalDateFormatter.format(userForCreateDataTransfer.getDateOfBirth()))
                .email(userForCreateDataTransfer.getEmail())
                .password(userForCreateDataTransfer.getPassword())
                .role(Role.valueOf(userForCreateDataTransfer.getRole()))
                .gender(Gender.valueOf(userForCreateDataTransfer.getGender()))
                .build();
    }
}
