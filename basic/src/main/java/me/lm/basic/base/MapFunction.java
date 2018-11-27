package me.lm.basic.base;

public class MapFunction {

    //HashMap 非线程安全 / null key value

    //HashMap 1.6 数组+链表
    //rehash (put->resize->transfer:链表循环)

    //HashMap 1.8 数组+链表+红黑树
    //rehash(put->resize ？？哪里线程不安全)
    //红黑树 put slpit ## 暂缓

    //final key(String/Integer)


    //(n-1) & hash  + capacity为2的幂 (优化桶索引的取模运算)
    //hash函数(高位优化?? h=hashcode & h >>>16)

    //ConcurrentHashMap 线程安全 / not null for key and value

    //ConcurrentHashMap 1.7  分段锁 数组+链表(Segment extends ReenterLock + HashBucket + HashEntry)
    //详细不解

    //ConcurrentHashMap 1.8 CAS（非阻塞无锁线程安全）+Synchronized 数组+链表+红黑树


}
