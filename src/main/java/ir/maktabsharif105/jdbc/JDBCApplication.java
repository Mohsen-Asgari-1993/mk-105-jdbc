package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.ProductCategory;
import ir.maktabsharif105.jdbc.repository.ProductCategoryRepository;
import ir.maktabsharif105.jdbc.repository.impl.ProductCategoryRepositoryImpl;
import ir.maktabsharif105.jdbc.util.ConnectionUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ProductCategoryRepository productCategoryRepository =
                new ProductCategoryRepositoryImpl(ConnectionUtil.getConnection());

        List<ProductCategory> allRootWithChildren = productCategoryRepository.findAllRootWithChildren();
        allRootWithChildren.forEach(System.out::println);
    }
}
