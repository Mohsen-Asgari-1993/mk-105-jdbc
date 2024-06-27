package ir.maktabsharif105.jdbc;

import lombok.*;

import java.util.Optional;
import java.util.Random;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        Optional<Person> optionalPerson = getOptionalPerson();
        Person person1 = optionalPerson.orElse(new Person());


        Person person = getPerson();
        if (person == null) {
            person = new Person();
        }
    }

    public static Optional<Person> getOptionalPerson() {
//        impl logic
        int i = new Random().nextInt(0, 10);
        return i >= 5 ? Optional.empty() : Optional.of(new Person());
//        return new Person();
    }

    public static Person getPerson() {
//        impl logic
        int i = new Random().nextInt(0, 10);
        return i >= 5 ? null : new Person();
//        return new Person();
    }


}


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Person {
    String firstName = "mohsen";
}