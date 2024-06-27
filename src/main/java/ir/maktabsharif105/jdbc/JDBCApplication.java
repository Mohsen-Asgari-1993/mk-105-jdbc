package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.City;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        List<Integer> integers = List.of(
                1, 15, 3, 45, 5, 16, 7, 81, 9, 10
        );

        Stream<Integer> integerStream = integers.stream();
        List<Integer> sortedList = integerStream.sorted(
                Integer::compareTo
        ).toList();
        System.out.println(sortedList);

    }

    public static List<City> findAllByIdIsIn(Collection<Integer> ids) {
        return new ArrayList<>();
    }

}