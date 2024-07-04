package ir.maktabsharif105.jdbc.service.impl;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.repository.CityGenericRepository;
import ir.maktabsharif105.jdbc.service.CityService;
import ir.maktabsharif105.jdbc.service.ProvinceService;

public class CityServiceImpl extends BaseEntityServiceImpl<City, Integer, CityGenericRepository>
        implements CityService {

    private final ProvinceService provinceService;


    //         CityServiceImpl(BaseEntityGenericRepository<City, Integer>
    public CityServiceImpl(CityGenericRepository baseRepository,
                           ProvinceService provinceService) {
        super(baseRepository);
        this.provinceService = provinceService;
    }

    @Override
    public City save(City entity) {
        if (entity.getProvince() == null || entity.getProvince().getId() == null) {
            throw new RuntimeException("empty province");
        }
        if (!provinceService.existsById(entity.getProvince().getId())) {
            throw new RuntimeException("wrong province");
        }
        return super.save(entity);
    }
}
