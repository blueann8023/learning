package me.lm.learning.cron;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;

/**
 * Created by blue_ann on 11/07/2018.
 */

public class Cron {
    @Test
    public void timer() throws InterruptedException {
        Timer timer = new Timer();
        IntStream.range(0, 4).forEach(i ->
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("ii");
                    }
                }, (i + 1) * 1000, 0));

        Thread.sleep(10000);
    }
}
