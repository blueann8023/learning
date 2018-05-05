package me.lm.learning.pattern;


public class Singleton {
    private Singleton() {
        System.out.print("Singleton Generate");
    }

    //饿汉
    private static Singleton singleton1 = new Singleton();

    public Singleton getSingleton1() {
        return singleton1;
    }

    //懒汉
    private static Singleton singleton2 = null;

    public synchronized Singleton getSingleton2() {
        if (singleton2 == null) {
            singleton2 = new Singleton();
        }
        return singleton2;
    }

    //Double Check Lock
    private static volatile Singleton singleton3 = null;

    public Singleton getSingleton3() {
        if (singleton3 == null) {
            synchronized (Singleton.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton();
                }
            }
        }
        return singleton3;
    }

    //静态内部类
    private static class SingletonHolder {
        private static final Singleton singleton4 = new Singleton();
    }

    public Singleton getSingleton4() {
        return SingletonHolder.singleton4;
    }

    //枚举
    public enum SingletonEnum {
        singleton5;
    }

    public SingletonEnum getSingleton5() {
        return SingletonEnum.singleton5;
    }
}
