package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        List<List<String>> lists = List.of(
                List.of("a"),
                List.of("b", "c"),
                List.of("d", "e", "f"),
                List.of("g")
        );

        System.out.println(lists);

        Stream<String> stringStream = lists.stream().flatMap(Collection::stream);
        System.out.println(
                stringStream.toList()
        );

    }

}