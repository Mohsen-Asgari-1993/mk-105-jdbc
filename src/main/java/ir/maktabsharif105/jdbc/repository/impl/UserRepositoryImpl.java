package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.User;
import ir.maktabsharif105.jdbc.repository.UserRepository;
import ir.maktabsharif105.jdbc.util.InsertKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class UserRepositoryImpl extends BaseUserRepositoryImpl<User>
        implements UserRepository {
    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Map<InsertKey, Object> getInsertMap(User entity) {
        return null;
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
    protected String[] getInsertColumnNamesArray() {
        return new String[0];
    }

    @Override
    protected void setInsertParamsInQuery(PreparedStatement preparedStatement, User entity) {

    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, User entity) {

    }

    @Override
    public User findByFirstName(String firstName) {
        return null;
    }
}
