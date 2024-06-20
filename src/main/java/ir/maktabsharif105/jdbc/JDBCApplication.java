package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.util.SemaphoreUtil;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class JDBCApplication {

    static Random random = new Random();

    static ReentrantLock lock = new ReentrantLock();

    static Semaphore semaphore = new Semaphore(1);

    @SneakyThrows
    public static void main(String[] args) {

        SemaphoreUtil.acquireCreateAdvert();
        try {
            System.out.println("logic");
        } finally {
            SemaphoreUtil.releaseCreateAdvert();
        }

        Long customerId = 5L;
        SemaphoreUtil.acquireCustomerSemaphore(5L);
        try {
            System.out.println("logic");
        } finally {
            SemaphoreUtil.releaseCustomerSemaphore(5L);
        }

        Thread thread = new Thread(
                () -> {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("start thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("end thread: " + Thread.currentThread().getName());
                    semaphore.release();
                }
        );
        semaphore.acquire();
        if (semaphore.tryAcquire(3, TimeUnit.SECONDS)) {

        } else {
            throw new RuntimeException();
        }

        thread.start();
        System.out.println("after start");
        Thread.sleep(1500);
        System.out.println("after sleep");
        semaphore.release();
        System.out.println("after release thread " + Thread.currentThread().getName());
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