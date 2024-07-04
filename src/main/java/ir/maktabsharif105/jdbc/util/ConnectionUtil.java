package ir.maktabsharif105.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final Connection CONNECTION;

    static {
        try {
            CONNECTION = DriverManager.getConnection(
                    ApplicationProperties.DB_URL,
                    ApplicationProperties.DB_USERNAME,
                    ApplicationProperties.DB_PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return CONNECTION;
    }

}
