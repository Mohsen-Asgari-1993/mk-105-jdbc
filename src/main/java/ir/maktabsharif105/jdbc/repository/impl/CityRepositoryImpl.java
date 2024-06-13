package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.CityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepositoryImpl extends BaseEntityRepositoryImpl implements CityRepository {

    public CityRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getInt("city_id"),
                resultSet.getString("city_name"),
                new Province(
                        resultSet.getLong("province_id"),
                        resultSet.getString("province_name")
                )
        );
    }

    @Override
    protected String getFindAllQuery() {
        return """
                select c.id as city_id, c.name as city_name,
                p.id as province_id, p.name as province_name
                from city c join province p on
                c.province_id = p.id
                """;
    }

    @Override
    protected String getFindByIdQuery() {
        return """
                select c.id as city_id, c.name as city_name,
                p.id as province_id, p.name as province_name
                from city c join province p on
                c.province_id = p.id where c.id = ?
                """;
    }

    @Override
    public boolean existsByName(String name) throws SQLException {
        return existsByNameSecond(name);
    }

    private boolean existsByNameFirst(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select name from city where name = ?"
        );
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    private boolean existsByNameSecond(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select count(*) from city where name = ?"
        );
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1) > 0;
    }

    //        public List<City> findAll() throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                """
//                        select c.id as city_id, c.name as city_name,
//                        p.id as province_id, p.name as province_name
//                        from city c join province p on
//                        c.province_id = p.id
//                        """
//        );
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<City> cityList = new ArrayList<>();
//        while (resultSet.next()) {
//            cityList.add(
//                    new City(
//                            resultSet.getLong("city_id"),
//                            resultSet.getString("city_name"),
//                            new Province(
//                                    resultSet.getLong("province_id"),
//                                    resultSet.getString("province_name")
//                            )
//                    )
//            );
//        }
//        return cityList;
//    }
}
