package me.lm.basic.java8;

public interface Furmula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
