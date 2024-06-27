package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {
        Hero hero = new Hero() {
            @Override
            public void fight() {
                System.out.println("fly");
            }

            @Override
            public void swim() {

            }

            @Override
            public void fly() {

            }
        };

        Hero second = new Hero() {
            @Override
            public void fight() {

            }

            @Override
            public void swim() {

            }

            @Override
            public void fly() {

            }
        };


    }
}

interface Hero {

    void fight();

    void swim();

    void fly();
}