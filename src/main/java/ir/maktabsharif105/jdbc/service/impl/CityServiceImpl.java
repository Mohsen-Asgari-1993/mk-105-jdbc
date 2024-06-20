package ir.maktabsharif105.jdbc.service.impl;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.repository.CityGenericRepository;
import ir.maktabsharif105.jdbc.service.CityService;
import ir.maktabsharif105.jdbc.util.SemaphoreUtil;

public class CityServiceImpl extends BaseEntityServiceImpl<City, Integer, CityGenericRepository>
        implements CityService {


    //         CityServiceImpl(BaseEntityGenericRepository<City, Integer>
    public CityServiceImpl(CityGenericRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public City save(City entity) {

        Long customerId = 5L;
        SemaphoreUtil.acquireCustomerSemaphore(5L);
        try {
            System.out.println("logic");
        } finally {
            SemaphoreUtil.releaseCustomerSemaphore(5L);
        }

        SemaphoreUtil.acquireCreateAdvert();
        try {
            return super.save(entity);
        } finally {
            SemaphoreUtil.releaseCreateAdvert();
        }
    }
}
