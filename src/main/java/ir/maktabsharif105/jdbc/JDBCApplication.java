package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.function.BiConsumer;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        test(
                JDBCApplication::print
        );
    }

    public static void print(Object o1, Object o2) {
        System.out.println(o1 + " " + o2);
    }

    public static void test(BiConsumer<String, String> biConsumer) {
        String s1 = "mohsen";
        String s2 = "ali";
        biConsumer.accept(s1, s2);
    }

}