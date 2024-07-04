package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.ProductCategory;
import ir.maktabsharif105.jdbc.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.util.List;

@RequiredArgsConstructor
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    private final Connection connection;

    @Override
    public List<ProductCategory> findAllRootWithChildren() {
//        TODO complete this method
        return null;
    }

}
