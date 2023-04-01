package org.example.service.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dto.ReadUserTransfer;
import org.example.model.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadableUserMapper implements Mapper<User, ReadUserTransfer> {
    @Getter
    private static final ReadableUserMapper readableUserMapper = new ReadableUserMapper();

    @Override
    public ReadUserTransfer mapFrom(User user) {
        return ReadUserTransfer.builder()
                .id(user.getId())
                .name(user.getName())
                .avatar(user.getAvatar())
                .dateOfBirth(user.getDateOfBirth())
                .email(user.getEmail())
                .role(user.getRole())
                .gender(user.getGender())
                .build();
    }
}
