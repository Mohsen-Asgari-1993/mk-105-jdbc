package ir.maktabsharif105.jdbc.service.impl;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.repository.CityGenericRepository;
import ir.maktabsharif105.jdbc.service.CityService;

public class CityServiceImpl extends BaseEntityServiceImpl<City, Integer, CityGenericRepository>
        implements CityService {


    //         CityServiceImpl(BaseEntityGenericRepository<City, Integer>
    public CityServiceImpl(CityGenericRepository baseRepository) {
        super(baseRepository);
    }
}
