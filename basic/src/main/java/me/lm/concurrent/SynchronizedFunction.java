package me.lm.concurrent;

//竞争 临界区 同步 锁/synchronized

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

//同步 lock/synchronized
//互斥 condition/wait and notify
public class SynchronizedFunction {

    //ReenterLock 排他锁 悲观锁 可设定是否公平  可重入 可等待 可中断
    //应用场景
    //1 有状态执行 已经执行则不再执行
    //2 同步执行 已经执行 等待一个个执行
    //3 尝试等待执行
    //4 同步执行，可中断
    //核心原理 AQS :volatile + CAS State + 等待线程进入队列(链表)
    private ReentrantLock reentrantLock = new ReentrantLock();
    //Condition 原理
    private Condition condition = reentrantLock.newCondition();
    //ReentrantReadWriteLock ReadWriteLock 排他锁+共享 悲观+乐观 可设定是否公平
    //核心原理 读写状态 + 等待队列
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    //CyclicBarrier  同步屏障
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    //Semaphore 信号量
    private Semaphore semaphore = new Semaphore(10);

    //AQS CAS + Queue实行


    //Synchronize


}
