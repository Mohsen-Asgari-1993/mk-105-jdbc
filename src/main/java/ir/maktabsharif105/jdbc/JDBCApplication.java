package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.List;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        List<String> words = List.of(
                "mohsen", "ali", "mahdi", "reza", "amirali", "shayan"
        );
        System.out.println();
        words.forEach(JDBCApplication::print);
        words.forEach(System.out::println);

    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
