package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.time.LocalTime;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("start: " + Thread.currentThread());
        Timer timer = new Timer();
        timer.start();
        Thread.sleep(20);
        timer.interrupt();
        System.out.println("end: " + Thread.currentThread());
    }
}

class Timer extends Thread {

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                System.out.println("Timer was interrupted");
                return;
            } else {
                System.out.println(LocalTime.now());
            }
        }
    }
}