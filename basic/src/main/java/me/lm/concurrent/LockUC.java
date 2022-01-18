package me.lm.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockUC {
    
   /**
    * @param
    * @return  
    * @author blue_ann 
    * @since 2021/11/30
    */
    public void lockUseCase() {
        Lock lock = new ReentrantLock();
        // 1
        lock.lock();//不在try中 confirm  no unlock when lock exception
        // 2 比sync多的
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 3 比sync多的
        lock.tryLock();
        // 4
        try {
            lock.tryLock(          1, TimeUnit.DAYS); // 阻塞的？
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 跟condition合作
        try {

        } finally {
            // 比sync多的更加可控灵活 在finally 模块中 confirm lock release
            lock.unlock();
        }
    }
}
