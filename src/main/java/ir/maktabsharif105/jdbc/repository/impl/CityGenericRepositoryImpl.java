package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.CityGenericRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityGenericRepositoryImpl
        extends BaseEntityGenericRepositoryImpl<City, Integer>
        implements CityGenericRepository {
    public CityGenericRepositoryImpl(Connection connection) {
        super(connection);
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
}
