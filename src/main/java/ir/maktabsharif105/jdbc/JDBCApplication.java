package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import lombok.*;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDBCApplication {

    static Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture.allOf(
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                ),
                CompletableFuture.runAsync(
                        () -> printWithSleep(), executorService
                )
        ).join();
        executorService.shutdown();
    }

    private static void printWithSleep() {
        System.out.println("start Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextLong(500, 2500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end Thread: " + Thread.currentThread().getName());
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