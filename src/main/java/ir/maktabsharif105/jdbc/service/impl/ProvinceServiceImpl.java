package ir.maktabsharif105.jdbc.service.impl;

import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.ProvinceGenericRepository;
import ir.maktabsharif105.jdbc.service.ProvinceService;

public class ProvinceServiceImpl extends BaseEntityServiceImpl<Province, Long, ProvinceGenericRepository>
        implements ProvinceService {

    public ProvinceServiceImpl(ProvinceGenericRepository baseRepository) {
        super(baseRepository);
    }

}
