package me.lm.learning.concurrent;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by blue_ann on 06/08/2018.
 */
public class FutureRunnableFunction {

    private volatile AtomicInteger counter = new AtomicInteger(0);

    private Callable callable = () -> {
        int i = counter.getAndIncrement();
        Thread.sleep(1000);
        System.out.println("Callable Task " + i);
        return i;
    };

    @Test
    public void testFutureTaskInThread() {
        RunnableFuture<Integer> runnableFuture = new FutureTask<Integer>(callable);
        Thread thread4Future = new Thread(runnableFuture);
        thread4Future.start();
        try {
            System.out.println(runnableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFutureTaskInThreadHaveProblem() {
        RunnableFuture<Integer> runnableFuture = new FutureTask<Integer>(callable);
        Thread thread4Future = new Thread(runnableFuture);
        Thread thread4Future2 = new Thread(runnableFuture);
        thread4Future.start();
        thread4Future2.start();
        try {
            System.out.println(runnableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testFutureTaskInThreadPool() {
        List<Future> futures = Lists.newArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0, 10).forEach(count -> {
            Future future = executorService.submit(callable);
            futures.add(future);
        });
        futures.stream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testFutureTaskInThreadPoolHaveProblem() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = null;
        for (int i = 0; i < 10; i++) {
            future = executorService.submit(callable);
        }
        try {
            System.out.println("Callable Task Result: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}