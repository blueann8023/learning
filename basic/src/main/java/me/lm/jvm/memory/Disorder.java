package me.lm.jvm.memory;

import me.lm.concurrent.VolatileUC;

/**
 * 乱序执行
 *
 * @author bule_ann
 * @since 2022/1/12
 */
public class Disorder {
    // 内存架构、因为内存速度比CPU慢、会有指令乱序执行的情况
    private static void main(String[] args) throws InterruptedException {
        VolatileUC.testOrdered();
    }
}
