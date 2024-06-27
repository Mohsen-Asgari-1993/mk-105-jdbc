package ir.maktabsharif105.jdbc;

import lombok.SneakyThrows;

import java.util.function.DoubleBinaryOperator;

public class JDBCApplication {

    @SneakyThrows
    public static void main(String[] args) {

        double x = 10;
        double y = 5;
        System.out.println(
                "DIVIDE: " + Operation.DIVIDE.apply(x, y)
        );
        System.out.println(
                "PLUS: " + Operation.PLUS.apply(x, y)
        );
    }
}

enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);


    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
//        return switch (this) {
//            case PLUS -> x + y;
//            case MINUS -> x - y;
//            case TIMES -> x * y;
//            case DIVIDE -> x / y;
//        };
        return op.applyAsDouble(x, y);
    }
}

