package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.time.LocalTime;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("start: " + Thread.currentThread());

        Thread thread = new Thread(
                new MySimpleRunnable()
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