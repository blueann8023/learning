package me.lm.basic.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.google.common.util.concurrent.RateLimiter;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

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

    @Test
    public void testFluentIterable() {
        List<Float> a = Lists.newArrayList(20.0f, 20.0f, 20f, 30f, 40f);
        a = FluentIterable.from(
                a
        ).

                filter(new Predicate<Float>() {
                    @Override
                    public boolean apply(@Nullable Float input) {
                        if (input == 20.0f) {
                            return false;
                        }
                        return true;
                    }
                }).limit(a.size() - 1).
                toList();
        a.stream().forEach(System.out::println);
    }

    @Test
    public void testMoney() {
        float a = 20.1f;
        System.out.println(testMoney(a));
        System.out.println(a);

    }

    public int testMoney(float merchantVoucherCouponMoney) {
        int merchantBearSeatNum = 0;
        List<Float> seatMoneiesDescSorted = Lists.newArrayList(20f, 20f, 30f, 40f);
        Collections.sort(seatMoneiesDescSorted, Collections.reverseOrder());
        List<Float> uemcardMoneies = Lists.newArrayList(30f, 40f);
        Collections.sort(uemcardMoneies, Collections.reverseOrder());

        for (int seatIndex = 0, uemcardIndex = 0; seatIndex < seatMoneiesDescSorted.size() && uemcardIndex < uemcardMoneies.size(); ) {
            float seatMoney = seatMoneiesDescSorted.get(seatIndex);
            float uemcardMoney = uemcardMoneies.get(uemcardIndex);
            if (seatMoney == uemcardMoney) {
                seatMoneiesDescSorted.set(seatIndex, 0.0f);
                seatIndex++;
                uemcardIndex++;
            } else {
                seatIndex++;
            }
        }

        float merchantVoucherCouponMoneyTemp = merchantVoucherCouponMoney;
        for (float seatMoney : seatMoneiesDescSorted) {
            if (seatMoney > 0.0f) {
                merchantVoucherCouponMoneyTemp -= seatMoney;
                if (merchantVoucherCouponMoneyTemp > 0.0f) {
                    merchantBearSeatNum++;
                }
            }
        }
        return merchantBearSeatNum;

    }


}
