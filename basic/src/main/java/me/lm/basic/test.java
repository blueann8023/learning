package me.lm.basic;

import org.joda.time.DateTime;

/**
 * Created by blue_ann on 13/03/2019.
 */
public class test {
    public static void main(String[] args) {
        String s = "[{\\\"priceMap\\\":{\\\"4953\\\":60},\\\"seatIds\\\":\\\"204481:A:8:4953,204481:A:7:4953\\\"}]";
        System.out.println(s.length());
        for (int i = 0; i < 3; i++) {
            DateTime dateTime = DateTime.now().minusMonths(i);
            System.out.println(String.format("movie_order_%02d", dateTime.getYear(), dateTime.getMonthOfYear()));
        }
    }

}
