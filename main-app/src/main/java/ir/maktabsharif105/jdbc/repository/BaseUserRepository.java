package ir.maktabsharif105.jdbc.repository;

import ir.maktabsharif105.jdbc.domain.User;

public interface BaseUserRepository<T extends User>
        extends BaseEntityGenericRepository<T, Long> {

    T findByUsernameAndPassword(String username, String password);

    T[] findAllByAgeIsGreaterThanOrEqual(Integer age);

    T findByFirstName(String firstName);

}
