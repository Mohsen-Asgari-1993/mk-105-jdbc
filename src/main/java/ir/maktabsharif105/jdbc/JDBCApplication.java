package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.time.LocalTime;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("start: " + Thread.currentThread());

        Thread thread = new Thread(
                () -> {
                    System.out.println("start: " + Thread.currentThread());
                    for (int i = 0; i < 4; i++) {
                        System.out.println(LocalTime.now());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("end: " + Thread.currentThread());
                }
        );
        thread.start();

        System.out.println("end: " + Thread.currentThread());
    }
}