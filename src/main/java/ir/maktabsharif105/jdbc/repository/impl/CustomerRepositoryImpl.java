package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.Customer;
import ir.maktabsharif105.jdbc.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.ResultSet;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer>
        implements CustomerRepository {
    public CustomerRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "customer";
    }

    @Override
    protected Customer mapResultSetToBaseEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    protected Customer[] getEntityArrayForFindAll() {
        return new Customer[(int) count()];
    }

    @Override
    public Customer findByFirstName(String firstName) {
        return null;
    }
}
