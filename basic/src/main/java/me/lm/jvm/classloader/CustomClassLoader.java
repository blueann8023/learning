package me.lm.jvm.classloader;

import me.lm.jvm.Hello;

import java.io.*;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/11
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String targetPath = "/Users/ann/Documents/GitWorkspace/learning/basic/target/classes";
        String s = ".";
        File classFile = new File(targetPath + "/" + name.replaceAll(s, "/") + ".class");
        try {
            FileInputStream fis = new FileInputStream(classFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int b = 0;
            while ((b = fis.read()) != 0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();

            baos.close();
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name); // throw exception
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> aClass = customClassLoader.loadClass("me.lm.jvm.Hello");
        Hello o = (Hello) aClass.newInstance();
        o.say();
    }
}
