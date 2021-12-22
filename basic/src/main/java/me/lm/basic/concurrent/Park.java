package me.lm.basic.concurrent;


import lombok.Setter;

import java.util.concurrent.locks.LockSupport;

public class Park {
    public static void main(String[] args) throws InterruptedException {
        PrintThread oddThread = new PrintThread(1,"odd");
        PrintThread evenThread = new PrintThread(2,"even");
        oddThread.setPeerThread(evenThread);
        evenThread.setPeerThread(oddThread);
        oddThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evenThread.start();
        oddThread.join();

    }

    static class PrintThread extends Thread {

        @Setter
        private Thread peerThread;

        private int initNumber;
        private int step = 2;

        public PrintThread(int initNumber,String name) {
            this(initNumber, 2);
        }

        public PrintThread(int initNumber, int step) {
            this.initNumber = initNumber;
            this.step = step;
        }

        @Override
        public void run() {
            int c = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + "   print : " + (initNumber + step * c));
                c++;
                if (peerThread != null) {
                    LockSupport.unpark(peerThread);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                LockSupport.park();
            }
        }
    }


}