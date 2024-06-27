package ir.maktabsharif105.jdbc;

import ir.maktabsharif105.jdbc.domain.BaseEntity;
import ir.maktabsharif105.jdbc.domain.City;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        List<City> cities = List.of(
                new City(2),
                new City(15),
                new City(8),
                new City(22),
                new City(45)
        );

        /*List<Integer> ids = new ArrayList<>();
        for (City city : cities) {
            ids.add(city.getId());
        }
        List<City> dbCities = findAllByIdIsIn(ids);*/
        List<City> dbCities = findAllByIdIsIn(
                cities.stream().map(BaseEntity::getId)
                        .collect(Collectors.toSet())
        );
    }

    public static List<City> findAllByIdIsIn(Collection<Integer> ids) {
        return new ArrayList<>();
    }

}