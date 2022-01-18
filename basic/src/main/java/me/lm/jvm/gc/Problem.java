package me.lm.jvm.gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/9
 */
public class Problem {

    private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100, new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String args[]) {
        for (; ; ) {

        }
    }

    private void temp() {
        this.getCards().forEach(card -> {
            scheduledThreadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        });
    }



    public static class Card {
        private String name;
        private BigDecimal money;

        public Card() {
        }

        public Card(String name, BigDecimal money) {
            this.name = name;
            this.money = money;
        }

        public void ansy() {
            System.out.println("ansy");
        }
    }

    private List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            cards.add(new Card("name", new BigDecimal(10.5)));
        }
        return cards;
    }

}
