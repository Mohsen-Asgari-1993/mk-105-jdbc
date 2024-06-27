package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

@Setter
@Getter
@NoArgsConstructor
public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        User user = User.userBuilder()
                .id(1L)
                .buildUser();

    }
}
