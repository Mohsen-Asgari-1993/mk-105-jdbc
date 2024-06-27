package ir.maktabsharif105.jdbc;

import lombok.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        List<String> numbers = List.of(
                "10", "15", "13", "7", "0", "55"
        );


        numbers.forEach(t -> System.out.println(t));
        numbers.forEach(System.out::println);


        numbers.forEach(t -> Integer.parseInt(t));
        numbers.forEach(Integer::parseInt);
        numbers.forEach(MyWrapper::new);
        numbers.forEach(String::toUpperCase);
        numbers.forEach(MyWrapper::new);

        List<Integer> arrayLengths = List.of(1, 5, 6);
        arrayLengths.stream()
                .map(length -> new int[length]);
        arrayLengths.stream()
                .map(int[]::new);

        List<Instant> instants = List.of(
                Instant.now().minus(5, ChronoUnit.DAYS),
                Instant.now().minus(2, ChronoUnit.DAYS),
                Instant.now().minus(2, ChronoUnit.HOURS)
        );
        instants.forEach(instant -> Instant.now().isAfter(instant));
        instants.forEach(Instant.now()::isAfter);

    }

    public static void print(Object o) {
        System.out.println(o);
    }
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class MyWrapper {
    private String myField;


}