package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.ProductCategory;
import ir.maktabsharif105.jdbc.repository.ProductCategoryRepository;
import ir.maktabsharif105.jdbc.repository.impl.ProductCategoryRepositoryImpl;
import ir.maktabsharif105.jdbc.util.ConnectionUtil;
import ir.maktabsharif115.smsprovider.KavenegarSender;
import ir.maktabsharif115.smsprovider.dto.SmsRequestDTO;
import ir.maktabsharif115.smsprovider.enumeration.SmsPurpose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.LinkedHashMap;
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

        KavenegarSender sender = new KavenegarSender();
        sender.send(
                new SmsRequestDTO(
                        "09121111111",
                        SmsPurpose.OTP,
                        new LinkedHashMap<>()
                )
        );
    }
}
