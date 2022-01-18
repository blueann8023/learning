package me.lm.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class ThreadUC {

    public static void main(String[] args) {
        multiThread();
    }

    public static void multiThread() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Arrays.stream(threadInfos).forEach(threadInfo -> System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName()));
    }

}
