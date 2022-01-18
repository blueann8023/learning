package me.lm.jvm.classloader;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/12
 */
public class ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(T.count);
        System.out.println(M.count);
    }

    static class T {
        public static T t = new T();
        public static int count = 3;

        private T() {
            count++;
        }
    }

    static class M {
        public static int count = 3;
        public static M m = new M();

        private M() {
            count++;
        }
    }
}
