package me.lm.basic.reference;

/**
 * ==对象不存在
 * 回收时可以收到通知
 * 当堆外内存被gc时jvm不会去处理内存
 * 使用Phantom指向堆外内存，可以感知到，用户自己去处理
 * DirectBufferByte
 * @author bule_ann
 * @since 2022/3/2
 */
public class Phantom {
}
