package ir.maktabsharif105.jdbc;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JDBCApplication {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person(15, "a"));
        people.add(new Person(10, "b"));
        people.add(new Person(18, "a"));
        people.add(new Person(20, "x"));
        people.add(new Person(25, "h"));
        people.add(new Person(23, "u"));
        System.out.println(people);
        people.sort(Comparator.comparing(Person::getAge));
        people.sort(
                new MyPersonComparator()
        );
        people.sort(
                (o1, o2) -> {
                    return Long.compare(o1.getAge(), o2.getAge());
                }
        );
        System.out.println(people);
        people.sort(Comparator.comparing(Person::getFirstName));
        System.out.println(people);
        people.sort(Comparator.comparing(Person::getFirstName).reversed());
        System.out.println(people);
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

    private Integer age;

    private String firstName;
}