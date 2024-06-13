package ir.maktabsharif105.jdbc.service.impl;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.repository.BaseEntityGenericRepository;
import ir.maktabsharif105.jdbc.service.BaseEntityService;

public class BaseEntityServiceImpl<T extends BaseEntity<ID>, ID, R extends BaseEntityGenericRepository<T, ID>>
        implements BaseEntityService<T, ID> {

    protected final R baseRepository;

    public BaseEntityServiceImpl(R baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return baseRepository.update(entity);
    }

    @Override
    public T[] findAll() {
        return baseRepository.findAll();
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

    @Override
    public void deleteAll() {
        baseRepository.deleteAll();
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return baseRepository.existsById(id);
    }
}
