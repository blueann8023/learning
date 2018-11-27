package me.lm.basic.effective.createordestroyobject.item6;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by blue_ann on 03/09/2018.
 */
public class NumberCheck {

    // not good
    public static boolean isNumber(String s) {
        return s.matches("a?b");
    }

    //
    private static final Pattern numberPattern = Pattern.compile("a?b");

    public static boolean isNumberWithStaticPattern(String s) {
        return numberPattern.matcher(s).matches();
    }



    //bad!! create pattern instance every time 99000000 14000000
    private  String s = "abcbfffff";
    public int getNumberCheckTakeTime() {

        int start = LocalDateTime.now().getNano();
        IntStream.range(1, 2).forEach(t -> System.out.println(NumberCheck.isNumber(s)));
        return  LocalDateTime.now().getNano() - start;
    }

    //79000000 11000000
    public int getNumberCheckWithStaticPatternnumberCheck() {
        int start = LocalDateTime.now().getNano();
        IntStream.range(1, 2).forEach(t -> System.out.println(NumberCheck.isNumberWithStaticPattern(s)));
        return LocalDateTime.now().getNano() - start;
    }

    @Test
    public void testNumerCheckPromotion(){
        System.out.println("testNumberCheck take time: " + getNumberCheckTakeTime());
        System.out.println("testNumberCheckWithStaticPattern take time: " + getNumberCheckWithStaticPatternnumberCheck());
    }

}
