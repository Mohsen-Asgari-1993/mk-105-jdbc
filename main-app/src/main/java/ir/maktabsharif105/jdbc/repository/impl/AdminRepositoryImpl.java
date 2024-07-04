package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.Admin;
import ir.maktabsharif105.jdbc.repository.AdminRepository;
import ir.maktabsharif105.jdbc.util.InsertKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class AdminRepositoryImpl extends BaseUserRepositoryImpl<Admin>
        implements AdminRepository {
    public AdminRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Map<InsertKey, Object> getInsertMap(Admin entity) {
        return null;
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
    protected String[] getInsertColumnNamesArray() {
        return new String[0];
    }

    @Override
    protected void setInsertParamsInQuery(PreparedStatement preparedStatement, Admin entity) {

    }

    @Override
    protected void setIdInNewEntity(ResultSet resultSet, Admin entity) {

    }

    @Override
    public Admin findByFirstName(String firstName) {
        return null;
    }
}
