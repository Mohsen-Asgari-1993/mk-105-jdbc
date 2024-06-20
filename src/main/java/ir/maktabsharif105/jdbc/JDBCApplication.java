package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;
import lombok.ToString;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread firstCounterThread = new Thread(
                () -> {
                    for (int i = 0; i < 100_000; i++) {
                        c.inc();
                    }
                }
        );
        Thread secondCounterThread = new Thread(
                () -> {
                    for (int i = 0; i < 100_000; i++) {
                        c.dec();
                    }
                }
        );
        secondCounterThread.start();
        firstCounterThread.start();

        firstCounterThread.join();
        secondCounterThread.join();
        System.out.println(c);
    }
}

@ToString
class Counter {

    private int value = 0;

    synchronized void inc() {
        value++;
//      1) get value
//      2) inc value by 1
//      3) update value
    }

    synchronized void dec() {
        value--;
//      1) get value
//      2) dec value by 1
//      3) update value
    }
}