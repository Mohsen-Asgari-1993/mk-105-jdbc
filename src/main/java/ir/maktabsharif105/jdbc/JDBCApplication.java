package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        List<List<String>> lists = List.of(
                List.of("x"),
                List.of("x", "x"),
                List.of("x", "x", "x"),
                List.of("a")
        );

        System.out.println(lists);

        Stream<String> stringStream = lists.stream().flatMap(Collection::stream);

        stringStream.findFirst().ifPresent(data -> System.out.println(
                String.join(
                        "$", data.toUpperCase(), "1", "2"
                )
        ));


    }

}