package ir.maktabsharif105.jdbc;

import lombok.*;

import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) throws SQLException {
        System.out.println(ZonedDateTime.now());
        Thread.sleep(1000);
        System.out.println(ZonedDateTime.now());
    }
}

class MyPersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Long.compare(o1.getAge(), o2.getAge());
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person {

    private Integer id;

    private Integer age;

    private String firstName;

    @Override
    public boolean equals(Object o) {
        System.out.println("in equals method: " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(age, person.age) && Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        System.out.println("in hashCode method: " + this);
        return new Random().nextInt();
    }
}