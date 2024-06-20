package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.repository.CityRepository;
import ir.maktabsharif105.jdbc.repository.impl.CityRepositoryImpl;
import ir.maktabsharif105.jdbc.util.ApplicationProperties;
import lombok.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class JDBCApplication {

    static Random random = new Random();

    @SneakyThrows
    public static void main(String[] args) {

        Connection connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD
        );

        LocalTime start = LocalTime.now();
        CityRepository cityRepository = new CityRepositoryImpl(connection);
        BaseEntity city = cityRepository.findById(10L);
        createLog(city);
        LocalTime end = LocalTime.now();
        System.out.println(city + " - Duration: " + Duration.between(start, end).toMillis());
        Thread.sleep(1000);
    }

    @SneakyThrows
    private static void createLog(BaseEntity city) {
//        createLogFirstVersion(city);

//        ExecutorService executorService =
//                Executors.newFixedThreadPool(2);

        CompletableFuture.runAsync(
                () -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("log created!!!");
                }

        );

    }

    private static void createLogFirstVersion(BaseEntity city) {
        new Thread(
                () -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("log created!!!");
                }
        ).start();
    }

    @SneakyThrows
    private static void setTotalCounts(DTO dto) {
        long sleep = random.nextLong(1000, 3000);
        System.out.println("setTotalCounts sleep: " + sleep);
        Thread.sleep(sleep);
        dto.setTotalCounts(random.nextLong(1, 100));

    }

    @SneakyThrows
    private static void setClosedCounts(DTO dto) {
        long sleep = random.nextLong(2000, 5000);
        System.out.println("setClosedCounts sleep: " + sleep);
        Thread.sleep(sleep);
        dto.setTotalCounts(random.nextLong(1, 100));
    }

    @SneakyThrows
    private static void setRejectedCounts(DTO dto) {
        long sleep = random.nextLong(200, 1000);
        System.out.println("setRejectedCounts sleep: " + sleep);
        Thread.sleep(sleep);
        dto.setRejectedCounts(random.nextLong(1, 100));
    }
}

@Setter
@Getter
@NoArgsConstructor
@ToString
class DTO {

    private long totalCounts;

    private long closedCounts;

    private long rejectedCounts;

    private long waitingCounts;

    private long acceptedCounts;

//    TODO override getter

}