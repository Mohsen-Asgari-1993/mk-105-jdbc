package ir.maktabsharif105.jdbc;

import lombok.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class JDBCApplication {

    static Random random = new Random();

    @SneakyThrows
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        DTO dto = new DTO();
        setTotalCounts(dto);
        setClosedCounts(dto);
        setRejectedCounts(dto);
        LocalTime end = LocalTime.now();
        System.out.println(dto);
        System.out.println(Duration.between(start, end).toMillis());
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