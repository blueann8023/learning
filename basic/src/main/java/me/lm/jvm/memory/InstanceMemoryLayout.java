package me.lm.jvm.memory;

import me.lm.jvm.Hello;
import org.openjdk.jol.info.ClassLayout;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/14
 */
public class InstanceMemoryLayout {
    public static void main(String[] args) {
        Hello hello = new Hello();
        System.out.println(ClassLayout.parseInstance(hello).toPrintable());

        synchronized (hello) {
            System.out.println(ClassLayout.parseInstance(hello).toPrintable());
        }
    }
}
