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

//        System.out.println("contains x: " + stringStream.anyMatch(data -> data.equals("x")));
//        System.out.println("contains x: " + stringStream.noneMatch(data -> data.equals("x")));
        System.out.println("contains x: " + stringStream.allMatch(data -> data.equals("x")));

    }

}