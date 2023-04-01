package org.example.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.dao.util.ConnectionManager;
import org.example.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDataAccess implements DataAccessibleObject<User, Integer> {
    private static final UserDataAccess DATA_ACCESS = new UserDataAccess();
    private static final String SQL_INSERT_USER_ENTITY = "insert into users(avatar, name, birthday, email, password, role, gender) " +
                                                         "values (?,?,?,?,?,?,?)";

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
