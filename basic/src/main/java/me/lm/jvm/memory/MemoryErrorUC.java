package me.lm.jvm.memory;

import me.lm.jvm.Hello;

import java.util.LinkedList;
import java.util.List;

/**
 * 内存错误案例
 *
 * @author bule_ann
 * @since 2022/1/14
 */
public class MemoryErrorUC {

    public static void main(String[] args) {
//        heapOOM();
//        vmstackSOF();
        vmstackOOM();
    }


    /**
     * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     *
     * @author blue_ann
     * @since 2022/1/14
     */
    public static void heapOOM() {
        List<Hello> helloList = new LinkedList<>();
        while (true) {
            helloList.add(new Hello());
        }
    }

    /**
     * VM Args:-Xss128k
     * 方法递归、大S量局部变量
     *
     * @author blue_ann
     * @since 2022/1/14
     */
    public static void vmstackSOF() {
        vmstackSOF();
    }

    /**
     * stack 可动态扩展   消耗栈的都可以
     * stack 不可动态扩展 不断创建线程
     *
     * @author blue_ann
     * @since 2022/1/14
     */
    public static void vmstackOOM() {
        while (true) {
            new Thread(() -> {
                while (true) {
                }
            }).start();
        }
    }

}
