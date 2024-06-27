package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        List<String> words = new ArrayList<>(
                List.of(
                        "mohsen", "ali", "mahdi", "reza", "amirali", "shayan"
                )
        );

        System.out.println(words);

//        Collections.sort(
//                words,
//                new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return Integer.compare(o1.length(), o2.length());
//                    }
//                }
//        );
//
//        words.sort((o1, o2) -> {
//            System.out.println("in concrete method:");
//            return Integer.compare(o1.length(), o2.length());
//        });

        words.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(words);


    }
}

interface Hero {

    void fight();

    static void swim() {

    }

    default void fly() {

    }

}