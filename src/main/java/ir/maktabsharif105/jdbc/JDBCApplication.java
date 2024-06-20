package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class JDBCApplication {

    static Random random = new Random();

    static ReentrantLock lock = new ReentrantLock();


    @SneakyThrows
    public static void main(String[] args) {

        Thread thread = new Thread(
                () -> {
                    tryToLock();
                }
        );
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println("after lock thread " + Thread.currentThread().getName());
        thread.start();
        System.out.println("after start");
        Thread.sleep(1500);
        System.out.println("after sleep");
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        System.out.println("after unlock thread " + Thread.currentThread().getName());
    }

    private static void tryToLock() {
        System.out.println("try to lock thread: " + Thread.currentThread().getName());
        System.out.println("thread: " + Thread.currentThread().getName() + " - " + lock.getHoldCount());
        lock.lock();
        System.out.println("thread: " + Thread.currentThread().getName() + " - " + lock.getHoldCount());
        System.out.println("start thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end thread: " + Thread.currentThread().getName());
        System.out.println("thread: " + Thread.currentThread().getName() + " - " + lock.getHoldCount());
        lock.unlock();
        System.out.println("thread: " + Thread.currentThread().getName() + " - " + lock.getHoldCount());
    }

}