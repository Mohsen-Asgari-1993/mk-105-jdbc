package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.ProvinceGenericRepository;
import ir.maktabsharif105.jdbc.util.InsertKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProvinceGenericRepositoryImpl
        extends BaseEntityGenericRepositoryImpl<Province, Long>
        implements ProvinceGenericRepository {
    public ProvinceGenericRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Map<InsertKey, Object> getInsertMap(Province entity) {
        Map<InsertKey, Object> insertMap = new HashMap<>();
        insertMap.put(new InsertKey(Province.NAME), entity.getName());
        return insertMap;
    }

    @Override
    protected String getTableName() {
        return Province.TABLE_NAME;
    }

    @Override
    protected Province mapResultSetToBaseEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    protected Province[] getEntityArrayForFindAll() {
        return new Province[(int) count()];
    }

    @Override
    protected void fillIdParameter(PreparedStatement statement, int paramIndex, Long id) {
        try {
            statement.setLong(paramIndex, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getInsertColumnNamesArray() {
        return new String[]{
                Province.NAME
        };
    }

    @Override
    protected void setInsertParamsInQuery(PreparedStatement preparedStatement, Province entity) {
        try {
            preparedStatement.setString(1, entity.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, Province entity) {
        try {
            entity.setId(
                    resultSet.getLong(1)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
