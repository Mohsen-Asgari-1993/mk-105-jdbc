package ir.maktabsharif105.jdbc;

import lombok.*;

import java.util.*;

public class JDBCApplication {

    public static void main(String[] args) {

        Set<Person> people = new TreeSet<>(
                Comparator.comparing(Person::getFirstName)
        );
        people.add(new Person(2, 21, "a"));
        people.add(new Person(1, 20, "a"));
        System.out.println(people);
        people.add(new Person(1, 30, "x"));
        System.out.println(people);
        people.add(new Person(2, 22, "f"));
        people.add(new Person(2, 23, "b"));
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