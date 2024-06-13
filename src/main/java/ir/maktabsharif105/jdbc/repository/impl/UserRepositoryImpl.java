package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.User;
import ir.maktabsharif105.jdbc.repository.UserRepository;

import java.sql.Connection;
import java.sql.ResultSet;

public class UserRepositoryImpl extends BaseUserRepositoryImpl<User>
        implements UserRepository {
    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "user";
    }

    @Override
    protected User mapResultSetToBaseEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    protected User[] getEntityArrayForFindAll() {
        return new User[(int) count()];
    }

    @Override
    public User findByFirstName(String firstName) {
        return null;
    }
}
