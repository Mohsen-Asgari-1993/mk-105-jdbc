package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;
import lombok.ToString;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        Counter c = new Counter();

        Thread firstCounterThread = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        Counter.staticInc();
                        c.inc();
                    }
                }
        );
        Thread secondCounterThread = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        Counter.staticDec();
                        c.dec();
                    }
                }
        );
        secondCounterThread.start();
        firstCounterThread.start();

        firstCounterThread.join();
        secondCounterThread.join();
        System.out.println(c);
        System.out.println(Counter.staticValue);
    }
}

@ToString
class Counter {

    private int value = 0;

    static int staticValue = 0;

    void inc() {
        synchronized (Counter.class) {
            System.out.println("inc");
            value++;
            staticValue++;
        }
//      1) get value
//      2) inc value by 1
//      3) update value
    }

    void dec() {
        synchronized (Counter.class) {
            System.out.println("dec");
            value--;
            staticValue--;
        }
//      1) get value
//      2) dec value by 1
//      3) update value
    }

    synchronized static void staticInc() {
        System.out.println("staticInc");
        staticValue++;
    }

    synchronized static void staticDec() {
        System.out.println("staticDec");
        staticValue--;
    }
}