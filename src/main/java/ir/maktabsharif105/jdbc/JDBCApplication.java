package ir.maktabsharif105.jdbc;

import lombok.*;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class JDBCApplication {

    public static void main(String[] args) throws SQLException {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getPriority());
        System.out.println(thread.getState());

        thread.setName("MyMain");
        thread.setPriority(8);

        System.out.println("after change properties:");
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
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