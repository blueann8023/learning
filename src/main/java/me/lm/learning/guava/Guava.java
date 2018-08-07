package me.lm.learning.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * Created by blue_ann on 12/07/2018.
 */
public class Guava {

    RateLimiter rateLimiter = RateLimiter.create(1);

    @Test
    public void testRateLimiter() {
        for (int i = 0; i < 12; i++) {
            rateLimiter.acquire(1);
            System.out.println(i);
        }

    }
}
