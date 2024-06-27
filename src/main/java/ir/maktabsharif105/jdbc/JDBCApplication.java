package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("in runnable");

        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(
                () -> System.out.println("anything")
        );
    }
}

interface Hero {

    void fight();

    static void swim() {

    }

    default void fly() {

    }

}