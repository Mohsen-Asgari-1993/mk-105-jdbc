package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        String first = "first";
        String second = "second";
        MyThread firstThread = new MyThread(1, first, second);
        MyThread secondThread = new MyThread(2, second, first);
    }
}

class MyThread extends Thread {
    String first, second;
    int id;

    MyThread(int id, String first, String second) {
        this.id = id;
        this.first = first;
        this.second = second;
        start();
    }

    @Override
    @SneakyThrows
    public void run() {
        synchronized (this.first) {
            System.out.println("thread with id: " + id + " in first sync: " + this.first);
            Thread.sleep(1000);
            System.out.println("thread with id: " + id + " try to get lock: " + this.second);
            synchronized (this.second) {
                System.out.println("thread with id: " + id + " in second sync: " + this.second);
            }
        }
    }
}