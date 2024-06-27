package ir.maktabsharif105.jdbc;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        Faker faker = new Faker();

        List<String> words = new ArrayList<>();

        IntStream.range(0, 30).forEach(i -> words.add(
                faker.name().firstName()
        ));

        Map<Integer, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(collect);

        Set<Map.Entry<Integer, List<String>>> entries = collect.entrySet();

        entries.forEach(System.out::println);

        System.out.println(
                entries.stream().collect(Collectors.groupingBy(x -> x.getValue().size()))
        );
//         1 = {10 = [Christiane], 2 = { 8 = [Bernardo, Valentin]}, 4 = { 3= [Joi, Rex, Gil, Lyn], 4=[Mike, Gigi, Jack, Maud]}}
    }

}