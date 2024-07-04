package ir.maktabsharif105.jdbc.repository;

import ir.maktabsharif105.jdbc.domain.BaseEntity;

import java.sql.SQLException;

public interface BaseEntityRepository {

    BaseEntity save(BaseEntity entity);

    BaseEntity update(BaseEntity entity);

    BaseEntity[] findAll() throws SQLException;

    BaseEntity findById(Long id);

    long count() throws SQLException;

    void deleteAll() throws SQLException;

    void deleteById(Long id) throws SQLException;

    boolean existsById(Long id) throws SQLException;
}
