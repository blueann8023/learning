package me.lm.learning.effective.createordestroyobject.item6;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

/**
 * Created by blue_ann on 03/09/2018.
 */
public class AutoBoxing {

    public int getPrimitiveLongTakeTime() {
        int start = LocalDateTime.now().getSecond();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
//        LongBinaryOperator longBinaryOperator = (x, y) -> x + y;
//        long sum = LongStream.range(0, Integer.MAX_VALUE).reduce(0L, longBinaryOperator);
        System.out.println(sum);
        return LocalDateTime.now().getSecond() - start;
    }

    // bad!1 mix auto boxing
    public int getMixAutoBoxingAndBaseLongTakeTime() {
        int start = LocalDateTime.now().getSecond();
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        return LocalDateTime.now().getSecond() - start;
    }

    @Test
    public void testLongPromotion(){
        System.out.println("getBaseLongTakeTime take time: " + getPrimitiveLongTakeTime());
        System.out.println("getMixAutoBoxingAndBaseLongTakeTime take time: " + getMixAutoBoxingAndBaseLongTakeTime());
    }

}
