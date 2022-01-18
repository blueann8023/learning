package me.lm.jvm.classloader;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/11
 */
public class ClassLoaderScope {
    public static void main(String[] args) {
        String boot = System.getProperty("sun.boot.class.path");
        System.out.println(boot.replaceAll(":",System.lineSeparator()));
        System.out.println();
        System.out.println();
        String ext = System.getProperty("java.ext.dirs");
        System.out.println(ext.replaceAll(":",System.lineSeparator()));
        System.out.println();
        System.out.println();
        String app = System.getProperty("java.class.path");
        System.out.println(app.replaceAll(":",System.lineSeparator()));
    }
}
