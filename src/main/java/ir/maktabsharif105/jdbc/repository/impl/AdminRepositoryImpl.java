package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.Admin;
import ir.maktabsharif105.jdbc.repository.AdminRepository;

import java.sql.Connection;
import java.sql.ResultSet;

public class AdminRepositoryImpl extends BaseUserRepositoryImpl<Admin>
        implements AdminRepository {
    public AdminRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "admin";
    }

    @Override
    protected Admin mapResultSetToBaseEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    protected Admin[] getEntityArrayForFindAll() {
        return new Admin[(int) count()];
    }

    @Override
    public Admin findByFirstName(String firstName) {
        return null;
    }
}
