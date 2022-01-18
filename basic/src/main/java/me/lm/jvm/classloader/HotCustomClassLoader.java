package me.lm.jvm.classloader;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/12
 */
public class HotCustomClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        CustomClassLoader customClassLoader = new CustomClassLoader();
//        Class<?> aClass = customClassLoader.loadClass("me.lm.jvm.mem.Hello");
//        Hello o = (Hello) aClass.newInstance();
//        o.say();
//
//        customClassLoader = new CustomClassLoader();
//        Class<?> bClass = customClassLoader.loadClass("me.lm.jvm.mem.Hello");
//        System.out.println(aClass == bClass);

        HotCustomClassLoader hotCustomClassLoader = new HotCustomClassLoader();
        Class<?> cClass = hotCustomClassLoader.loadClass("me.lm.jvm.Hello");
        System.out.println(cClass.hashCode());

        hotCustomClassLoader = new HotCustomClassLoader();
        Class<?> dClass = hotCustomClassLoader.loadClass("me.lm.jvm.Hello");

        System.out.println(dClass.hashCode());
        System.out.println(cClass == dClass);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File classFile = new File("/Users/ann/Documents/GitWorkspace/learning/basic/target/classes/" + StringUtils.replace(name, ".", "/") + ".class");
        if (!classFile.exists()) {
            return super.loadClass(name);
        }
        try {
            FileInputStream fis = new FileInputStream(classFile);
            byte[] bytes = fis.readAllBytes();
            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.loadClass(name);
    }


}
