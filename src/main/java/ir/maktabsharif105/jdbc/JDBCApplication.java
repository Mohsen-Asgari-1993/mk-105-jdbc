package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.util.QueryUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Arrays;

@Setter
@Getter
@NoArgsConstructor
public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        String[] cityColumns = new String[]{
                City.NAME,
                City.PROVINCE_ID
        };
        String columnNames = String.join(
                ",",
                cityColumns
        );
        Arrays.fill(cityColumns, "?");
        String questionMarks = String.join(
                ",",
                cityColumns
        );
        System.out.println(QueryUtil.INSERT_QUERY_TEMPLATE);

        System.out.printf(
                QueryUtil.INSERT_QUERY_TEMPLATE,
                City.TABLE_NAME,
                columnNames,
                questionMarks
        );
//        System.out.println(
//                String.join(
//                        ",",
//                        "first_name",
//                        "last_name",
//                        "username",
//                        "password"
//                )
//        );

    }
}
