package me.lm.jvm.classloader;



/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/11
 */
public class ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());// null bootstrap
//        System.out.println(DNSNameService.class.getClassLoader());//sun.misc.Launcher$ExtClassLoader
        System.out.println(ClassLoaderLevel.class.getClassLoader());//sun.misc.Launcher$AppClassLoader

//        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());//? 为啥null呢？

        System.out.println(ClassLoaderLevel.class.getClassLoader().getParent());
        System.out.println(ClassLoaderLevel.class.getClassLoader().getParent().getParent());
    }
}
