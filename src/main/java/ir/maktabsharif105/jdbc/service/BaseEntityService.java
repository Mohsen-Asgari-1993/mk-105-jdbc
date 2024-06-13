package ir.maktabsharif105.jdbc.service;

import ir.maktabsharif105.jdbc.domain.BaseEntity;

public interface BaseEntityService<T extends BaseEntity<ID>, ID> {

    T save(T entity);

    T update(T entity);

    T[] findAll();

    T findById(ID id);

    long count();

    void deleteAll();

    void deleteById(ID id);

    boolean existsById(ID id);
}
