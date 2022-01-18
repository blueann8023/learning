package me.lm.jvm.memory;

import java.lang.instrument.Instrumentation;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/12
 */
public class ObjectSizeAgent {

    //调试
    private static Instrumentation inst;

    public static void premain(String args, Instrumentation _inst) {
        inst = _inst;
    }
    public static long sizeof(Object object) {
        return inst.getObjectSize(object);
    }
}
