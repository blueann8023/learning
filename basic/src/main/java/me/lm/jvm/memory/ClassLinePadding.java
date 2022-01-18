package me.lm.jvm.memory;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/12
 */
public class ClassLinePadding {

    private static volatile T[] arr = new T[2];
    private static volatile P[] arr1 = new P[2];

    static {
        for (int i = 0; i < 2; i++) {
            arr[i] = new T();
            arr1[i] = new P();
        }
    }

    static class P extends T {
        // mark world = 4 class pointer = 4/8
        public volatile long p1, p2, p3, p4, p5, p6; // 300ms
        // public volatile long p1, p2, p3, p4, p5; //100ms
    }

    static class T {
        public volatile long x; //没感觉
    }

    public static void main(String[] args) throws InterruptedException {

        long start1 = System.currentTimeMillis();
        Thread t3 = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) {
                arr1[0].x = i;
            }
        });
        Thread t4 = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) {
                arr1[1].x = i;
            }
        });
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println(System.currentTimeMillis() - start1);

        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000; i++) {
                arr[1].x = i;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() - start);

    }
}
