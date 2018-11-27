package me.lm.basic.java8;

@FunctionalInterface
public interface Game<T> {
    void play(T gameName);
}
