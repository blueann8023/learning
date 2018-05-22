package me.lm.learning.java8;

@FunctionalInterface
public interface Game<T> {
    void play(T gameName);
}
