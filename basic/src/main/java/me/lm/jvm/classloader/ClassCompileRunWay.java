package me.lm.jvm.classloader;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/11
 */
public class ClassCompileRunWay {
    public static void main(String[] args) {
        int j;
        int m;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            j = i * 3;
            m = j;
        }

        for (int i = 0; i < 1000000000; i++) {
            j = i * 3;
            m = j;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
