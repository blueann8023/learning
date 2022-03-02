package me.lm.basic.reference;

import java.io.IOException;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/3/2
 */
public class Normal {
    public static void main(String[] args) throws IOException {
        Object o = new Object();
        o = null;
        System.gc();
        System.in.read();
    }
}
