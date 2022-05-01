package me.lm.basic.base;

import org.junit.Test;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/4/5
 */
public class DataStructure {


    public static void main(String[] args) {
        int i = 1;
        transform(i);
        System.out.println(i);

        String s = "1";
        transform(s);
        System.out.println(s);

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        transform(sb);
        System.out.println(sb);


    }

    public static void transform(int i) {
        i++;
    }

    public static void transform(String s) {
        s = s + "3";
    }

    public static void transform(StringBuilder sb) {
        sb.append(2);
    }

    @Test
    public void cache() {
        Integer a = 2;
        Integer b = 2;
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
    }

}
