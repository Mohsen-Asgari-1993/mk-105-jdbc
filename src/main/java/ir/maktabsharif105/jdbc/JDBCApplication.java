package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.City;
import ir.maktabsharif105.jdbc.domain.Province;
import ir.maktabsharif105.jdbc.repository.CityGenericRepository;
import ir.maktabsharif105.jdbc.repository.impl.CityGenericRepositoryImpl;
import ir.maktabsharif105.jdbc.util.ApplicationProperties;
import lombok.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class JDBCApplication {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USERNAME,
                ApplicationProperties.DB_PASSWORD
        );
        connection.setAutoCommit(true);
        CityGenericRepository cityGenericRepository = new CityGenericRepositoryImpl(connection);
        cityGenericRepository.save(
                new City(null, "پاکدشت", new Province(1L, null))
        );
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