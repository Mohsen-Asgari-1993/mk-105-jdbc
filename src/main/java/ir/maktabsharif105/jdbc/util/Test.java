package ir.maktabsharif105.jdbc.util;/*
package ir.maktabsharif.jdbcexample.util;

import ir.maktabsharif.jdbcexample.domain.City;
import ir.maktabsharif.jdbcexample.domain.Province;
import ir.maktabsharif.jdbcexample.repository.ProvinceRepository;
import ir.maktabsharif.jdbcexample.repository.impl.CityRepositoryImpl;
import ir.maktabsharif.jdbcexample.repository.impl.ProvinceRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void createCity(CityCreationDTO dto) throws SQLException {
        Connection connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD
        );
        connection.setAutoCommit(true);

        ProvinceRepository provinceRepository = new ProvinceRepositoryImpl(connection);
        Province province = (Province) provinceRepository.findById(dto.getProvinceId());
        if (province == null) {
            throw new RuntimeException("invalid provinceId");
        }
        City city = new City();
        city.setName(dto.getName());
        city.setProvince(province);
        new CityRepositoryImpl(connection)
                .save(city);
        connection.close();
    }
}
*/
