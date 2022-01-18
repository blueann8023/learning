package me.lm.concurrent;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/10
 */
public class VolatileUC {

    public static void main(String[] args) throws InterruptedException {
//        testVisible();
        testOrdered();
    }


    //    加了volatile也可以停
//    private static volatile boolean stop = false;
    private static boolean stop = false;
    public static void testVisible() throws InterruptedException {
        // 主线程都停止了呀？？为啥子线程没停呢
        //
        new Thread(() -> {
            while (!stop) {
                System.out.println("working"); // 为啥加这个就会停
            }
            System.out.println("end");
        }, "server").start();
        Thread.sleep(1000);
        stop = true;
    }


    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void testOrdered() throws InterruptedException {
        while (true) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            if (x == 0 && y == 0) {
                System.err.println("error");
                break;
            }
        }
    }
}
