package ir.maktabsharif105.jdbc.repository;

import ir.maktabsharif105.jdbc.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {

    List<ProductCategory> findAllRootWithChildren();

}
