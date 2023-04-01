package org.example.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.util.PropertiesLoader;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AvatarService {
    @Getter
    private static final AvatarService avatarService = new AvatarService();

    private final String basePathImg = PropertiesLoader.getPropertyByKey("avatar.base_url");

    @SneakyThrows
    public void upload(String avatarPath, InputStream inputStreamContent) {
        Path avatarFullPath = Path.of(basePathImg, avatarPath);
        try (inputStreamContent) {
            Files.createDirectories(avatarFullPath.getParent());
            Files.write(avatarFullPath, inputStreamContent.readAllBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
