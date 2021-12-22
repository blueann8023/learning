package me.lm.basic.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 并发工具类使用例子
 *
 * @author bule_ann
 * @since 2021/12/16
 */
public class ConcurrentUtilUseCase {

    /**
     * CountDownLatch
     * 并发流程控制手段 主任务等待子任务
     * 类似Thread.join，功能更丰富
     * 合并计算
     *
     * @author blue_ann
     * @since 2021/12/16
     */
    @Test
    public void testCountDownLatch() {
        // 并发流程控制手段 多个线程countdown 多个线程await
        // 共享 公平
        // 核心原理 AQS + count为同步状态 countdown release 1、 await tryRelease 特殊实现==0 为获取到
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("1");
            countDownLatch.countDown();
            System.out.println("2");
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }

    /**
     * CyclicBarrier可循环使用同步屏障
     * 并发流程控制手段 并行任务
     * 压测
     *
     * @author blue_ann
     * @since 2021/12/16
     */
    @Test
    public void testCyclicBarrier() {
        // 共享 公平
        // 核心原理 reenterlock + condition + parties
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    System.out.println("run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        try {
            System.out.println("go");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    /**
     * Semaphore
     * 并发线程数量控制手段
     * 流量控制-数据库连接
     *
     * @author blue_ann
     * @since 2021/12/16
     */
    @Test
    public void testSemaphore() {

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    semaphore.acquire();
                    System.out.println(" save data");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("save data");
            });
        }
        executorService.shutdown();
    }

    /**
     * Exchanger 多线程数据交换
     * 数据缓冲池交换 双队列数据缓冲池
     * @param
     * @return
     * @author blue_ann
     * @since 2021/12/17
     */
    @Test
    public void testExchanger() {
        Exchanger<Long> exchanger = new Exchanger<>();
        Long in = 1L, out = 2L;
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                Long current = in;
                try {
                    Long exchange = exchanger.exchange(current);
                    System.out.println("in" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                Long current = out;
                try {
                    Long exchange = exchanger.exchange(current);
                    System.out.println("out" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();


    }
}
