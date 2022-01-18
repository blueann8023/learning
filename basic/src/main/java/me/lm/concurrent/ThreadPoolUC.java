package me.lm.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池使用案例
 *
 * @author bule_ann
 * @since 2021/12/27
 */
public class ThreadPoolUC {

    /**
     * 线程池执行器使用案例
     * @param 
     * @return 
     * @author blue_ann 
     * @since 2021/12/27
     */
    @Test
    public void createThreadPool() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<Integer> submit = threadPoolExecutor.submit(() -> {
            System.out.println("task");
            return 1;
        });
        try {
            System.out.println(submit.get().intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    /**
     * 定期线程池执行器使用案例
     * @param
     * @return
     * @author blue_ann
     * @since 2021/12/27
     */
    @Test
    public void createScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("task scheduleAtFixedRate");
            }
        }, 10, 1000, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("task scheduleWithFixedDelay");
            }
        },10,1000,TimeUnit.MILLISECONDS);

        try {
            scheduledFuture.get();
            System.out.println("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
