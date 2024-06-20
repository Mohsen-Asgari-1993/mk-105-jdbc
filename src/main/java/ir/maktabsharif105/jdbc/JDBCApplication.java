package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.time.LocalTime;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("start: " + Thread.currentThread());
//        new MySimpleThread().start();
        MySimpleThread thread = new MySimpleThread();
        thread.start();
        System.out.println("end: " + Thread.currentThread());
    }
}

class MySimpleThread extends Thread {

//    public MySimpleThread() {
//        start();
//    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println("start: " + Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            System.out.println(LocalTime.now());
            Thread.sleep(1000);
        }
        System.out.println("end: " + Thread.currentThread());
    }
}