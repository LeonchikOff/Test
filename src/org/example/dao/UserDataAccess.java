package org.example.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.dao.util.ConnectionManager;
import org.example.model.Gender;
import org.example.model.Role;
import org.example.model.entity.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDataAccess implements DataAccessibleObject<User, Integer> {
    private static final UserDataAccess DATA_ACCESS = new UserDataAccess();
    private static final String SQL_INSERT_USER_ENTITY
            = "insert into users(avatar, name, birthday, email, password, role, gender) " +
              "values (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_EMAIL_AND_PASSWORD
            = "select id, avatar, name, birthday, email, password, role, gender " +
              "from users where email=? and password=?";

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SQL_INSERT_USER_ENTITY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getAvatar());
            preparedStatement.setObject(2, entity.getName());
            preparedStatement.setObject(3, entity.getDateOfBirth());
            preparedStatement.setObject(4, entity.getEmail());
            preparedStatement.setObject(5, entity.getPassword());
            preparedStatement.setObject(6, entity.getRole().name());
            preparedStatement.setObject(7, entity.getGender().name());
            preparedStatement.executeUpdate();
            ResultSet generatedIdResultSet = preparedStatement.getGeneratedKeys();
            generatedIdResultSet.next();
            entity.setId(generatedIdResultSet.getObject("id", Integer.class));
            return entity;
        }
    }


    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email, String password) {
        User user = null;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                user = populateUserEntity(resultSet);
            return Optional.ofNullable(user);
        }

    }


    private User populateUserEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .avatar(resultSet.getObject("avatar", String.class))
                .name(resultSet.getObject("name", String.class))
                .dateOfBirth(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.valueOf(resultSet.getObject("role", String.class)))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public static UserDataAccess getDataAccess() {
        return DATA_ACCESS;
    }
}
