package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.CityGenericRepository;
import ir.maktabsharif105.jdbc.util.InsertKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CityGenericRepositoryImpl
        extends BaseEntityGenericRepositoryImpl<City, Integer>
        implements CityGenericRepository {
    public CityGenericRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Map<InsertKey, Object> getInsertMap(City entity) {
        Map<InsertKey, Object> insertMap = new HashMap<>();
        insertMap.put(new InsertKey(City.NAME), entity.getName());
        insertMap.put(new InsertKey(City.PROVINCE_ID), entity.getProvince().getId());
        return insertMap;
    }

    @Override
    protected String getTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected City mapResultSetToBaseEntity(ResultSet resultSet) {
        try {
            return new City(
                    resultSet.getInt("city_id"),
                    resultSet.getString("city_name"),
                    new Province(
                            resultSet.getLong("province_id"),
                            resultSet.getString("province_name")
                    )
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected City[] getEntityArrayForFindAll() {
        return new City[(int) count()];
    }

    @Override
    protected void fillIdParameter(PreparedStatement statement, int paramIndex, Integer id) {
        try {
            statement.setInt(paramIndex, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String[] getInsertColumnNamesArray() {
        return new String[]{
                City.NAME,
                City.PROVINCE_ID
        };
    }

    @Override
    protected void setInsertParamsInQuery(PreparedStatement preparedStatement, City entity) {
        try {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getProvince().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, City entity) {
        try {
            entity.setId(
                    resultSet.getInt(1)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
