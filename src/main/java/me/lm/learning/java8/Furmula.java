package me.lm.learning.java8;

public interface Furmula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
