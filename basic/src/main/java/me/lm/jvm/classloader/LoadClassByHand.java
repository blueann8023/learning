package me.lm.jvm.classloader;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/11
 */
public class LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = LoadClassByHand.class.getClassLoader().loadClass("me.lm.jvm.classloader.ClassLoaderLevel");
        System.out.println(clazz.getName());
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClass().getName());
        System.out.println(clazz.getClass().getClassLoader());
    }
}
