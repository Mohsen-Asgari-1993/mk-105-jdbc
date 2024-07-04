package ir.maktabsharif105.jdbc.repository.impl;

import ir.maktabsharif105.jdbc.domain.ProductCategory;
import ir.maktabsharif105.jdbc.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    private final Connection connection;

    @Override
    public List<ProductCategory> findAllRootWithChildren() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                            select * from product_category order by
                            case when parent_id is null then 1 else 2 end, parent_id, id
                            """
            );
            return findAllRootWithChildren(
                    preparedStatement.executeQuery()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<ProductCategory> findAllRootWithChildren(ResultSet resultSet) {
        List<ProductCategory> productCategories = new ArrayList<>();
        Map<Long, ProductCategory> productCategoryMap = new HashMap<>();
        try {
            while (resultSet.next()) {
                ProductCategory productCategory =
                        ProductCategory.builder()
                                .id(resultSet.getLong("id"))
                                .title(resultSet.getString("title"))
                                .children(new ArrayList<>())
                                .build();
                productCategoryMap.put(productCategory.getId(), productCategory);
                long parentId = resultSet.getLong("parent_id");
                if (parentId == 0) {
                    productCategories.add(productCategory);
                } else {
                    ProductCategory parent = productCategoryMap.get(parentId);
                    List<ProductCategory> parentChildren = parent.getChildren();
                    parentChildren.add(productCategory);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productCategories;
    }

}
