package me.lm.basic.reference;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 *
 *
 * @author bule_ann
 * @since 2022/3/2
 */
public class Soft {
    public static void main(String[] args) throws IOException {
        SoftReference<byte[]> sr = new SoftReference(new byte[100]);
        System.gc();
        System.out.println(sr.get());
        System.gc();
        System.out.println(sr.get());

        byte[] m = new byte[1024*1024*1024];
        System.gc();
        System.out.println(sr.get());
    }
}
