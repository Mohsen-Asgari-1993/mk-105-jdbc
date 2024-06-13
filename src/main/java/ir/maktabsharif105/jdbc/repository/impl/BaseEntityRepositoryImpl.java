package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.repository.BaseEntityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ir.maktabsharif105.jdbc.util.QueryUtil.*;

public abstract class BaseEntityRepositoryImpl implements BaseEntityRepository {

    protected final Connection connection;

    public BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity[] findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                getFindAllQuery()
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        BaseEntity[] baseEntities = new BaseEntity[(int) count()];
        int arrayIndex = 0;
        while (resultSet.next()) {
            baseEntities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
        }

        return baseEntities;
    }

    @Override
    public BaseEntity findById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    getFindByIdQuery()
            );
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            return mapResultSetToBaseEntity(resultSet);
//        }
//        return null;
            return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public long count() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        COUNT_ALL_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }

    @Override
    public void deleteAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_ALL_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_BY_ID_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        EXISTS_BY_ID_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1) > 0;
    }

    protected String getFindAllQuery() {
        return String.format(
                FIND_ALL_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected String getFindByIdQuery() {
        return String.format(
                FIND_BY_ID_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected abstract String getTableName();

    protected abstract BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException;


}
