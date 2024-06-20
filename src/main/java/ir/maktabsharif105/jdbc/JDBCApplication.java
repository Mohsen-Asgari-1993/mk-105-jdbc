package ir.maktabsharif105.jdbc;

import lombok.*;

import java.util.Random;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        DTO dto = new DTO();
        Random random = new Random();
        Thread firstThread = new Thread(
                () -> {
                    System.out.println(
                            "in thread: " + Thread.currentThread().getName() + " setTotalCounts"
                    );
                    try {
                        Thread.sleep(random.nextLong(1000, 3000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    dto.setTotalCounts(
                            random.nextLong(0, 100)
                    );
                    System.out.println(
                            "in thread: " + Thread.currentThread().getName() + " --- " + dto
                    );
                }
        );
        Thread secondThread = new Thread(
                () -> {
                    System.out.println(
                            "in thread: " + Thread.currentThread().getName() + " setActiveCounts"
                    );
                    try {
                        Thread.sleep(random.nextLong(1000, 3000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    dto.setActiveCounts(
                            random.nextLong(0, 100)
                    );
                    System.out.println(
                            "in thread: " + Thread.currentThread().getName() + " --- " + dto
                    );
                }
        );
        firstThread.start();
        secondThread.start();
        System.out.println("before firstThread.join()");
        firstThread.join();
        System.out.println("after firstThread.join()");
        System.out.println("before secondThread.join()");
        secondThread.join();
        System.out.println("after secondThread.join()");
        System.out.println(
                "in thread: " + Thread.currentThread().getName() + " --- " + dto
        );

    }
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class DTO {

    private long totalCounts;

    private long activeCounts;

}