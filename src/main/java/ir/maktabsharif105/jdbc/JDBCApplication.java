package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.stream.Stream;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        );

        Stream<Integer> integerStream1 = integerStream.filter(num -> num % 2 != 0);
        Stream<Integer> integerStream2 = integerStream1.map(num -> num * 5);
        integerStream2.forEach(System.out::println);
    }

}