package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.ProvinceRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceRepositoryImpl extends BaseEntityRepositoryImpl implements ProvinceRepository {

    public ProvinceRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Province.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return new Province(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }

//    public List<Province> findAll() throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                "select * from province"
//        );
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<Province> provinces = new ArrayList<>();
//        while (resultSet.next()) {
//            provinces.add(
//                    new Province(
//                            resultSet.getLong("id"),
//                            resultSet.getString("name")
//                    )
//            );
//        }
//        return provinces;
//    }
}
