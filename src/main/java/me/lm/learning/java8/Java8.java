package me.lm.learning.java8;

import org.junit.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.PrintStream;

public class Java8 {

    // default method for interface
    // list iteracotr issue ??
    @Test
    public void defaultMethodForInterface() {
        Furmula furmula = new Furmula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };
        furmula.calculate(10);

        furmula.sqrt(10);
    }

    // functional interface
    @Test
    public void functionalInterface() {
        Game<String> game = new Game<String>() {
            @Override
            public void play(String gameName) {
                System.out.print(gameName);
            }
        };
        game.play("GoGo");
        Game<String> game1 = System.out::print;
    }

}
