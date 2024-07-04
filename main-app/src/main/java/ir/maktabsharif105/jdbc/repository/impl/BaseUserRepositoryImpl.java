package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.User;
import ir.maktabsharif105.jdbc.repository.BaseUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseUserRepositoryImpl<T extends User>
        extends BaseEntityGenericRepositoryImpl<T, Long>
        implements BaseUserRepository<T> {
    public BaseUserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public T findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public T[] findAllByAgeIsGreaterThanOrEqual(Integer age) {
        return null;
    }


    @Override
    protected void fillIdParameter(PreparedStatement statement, int paramIndex, Long id) {
        try {
            statement.setLong(paramIndex, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
