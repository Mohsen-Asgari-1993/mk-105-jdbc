package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.time.LocalTime;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("start: " + Thread.currentThread());

        Runnable runnable = () -> {
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
        };

        Thread thread = new Thread(
                runnable
        );
        thread.start();

        System.out.println("end: " + Thread.currentThread());
    }
}

class MySimpleRunnable implements Runnable {

//    public MySimpleThread() {
//        start();
//    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println("start: " + Thread.currentThread());
        for (int i = 0; i < 4; i++) {
            System.out.println(LocalTime.now());
            Thread.sleep(1000);
        }
        System.out.println("end: " + Thread.currentThread());
    }
}