package ir.maktabsharif105.jdbc.repository;

import ir.maktabsharif105.jdbc.domain.BaseEntity;

import java.sql.SQLException;

public interface CityRepository extends BaseEntityRepository {

    boolean existsByName(String name) throws SQLException;

    @Override
    BaseEntity save(BaseEntity entity);

    @Override
    BaseEntity update(BaseEntity entity);

    @Override
    BaseEntity[] findAll() throws SQLException;

    @Override
    BaseEntity findById(Long id);

    @Override
    long count() throws SQLException;

    @Override
    void deleteAll() throws SQLException;

    @Override
    void deleteById(Long id) throws SQLException;

    @Override
    boolean existsById(Long id) throws SQLException;
}
