package me.lm.basic.base;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ObjectFunction implements Cloneable, Serializable {

    String name;
    int age;

    // == 基础类型值对比/引用类型引用地址对比
    //equals  基类Object相当于== 可以重写 现实真实意义的值判断
    //equals 重写5大原则：自反 对称 传递 一致 非空
    //equals 必定重写hashCode 原因是hash机制的集合需要
    //equals 一般标准写法

    @Override
    public boolean equals(Object obj) {
        //引用检查 
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        //子类语义不同用getClass，相同如HashSet可以用instanceof
        if (getClass() != obj.getClass())
            return false;
        //转类 进行属性对比 基础类型用== 引用用equals( Arrays.equals()/  Objects.equals())
        ObjectFunction other = (ObjectFunction) obj;
        return other.age == this.age && Objects.equals(other, this);
        //子类可以先包含super.equals();

    }

    // hashCode Object native方法 虚拟内存地址的一定hash算法后的值 身份标识
    // hashCode 一致性 equals则hashCode值必须等 equals重写后必须重写hashCode hashCode相同不一定equals
    // 重写

    @Override
    public int hashCode() {
        //Objects.hashCode(); Objects.hash(); Arrays.hashCode();
        //return 3 * name.hashCode() + 5 * Objects.hashCode(age);
        return Objects.hash(name, age);
    }


    // clone: 原型模型 native方法 内存块的复制
    // 重写 implements Cloneable 可调用Object super.clone();
    // 浅拷贝 深拷贝：可序列化实现深拷贝
    @Override
    public Object clone() {
        ObjectFunction o = null;
        try {
            o = (ObjectFunction) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public ObjectFunction deepClone(ObjectFunction obj) {
        //implement Serializable
        ObjectFunction o = null;

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            o = (ObjectFunction) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return o;
    }

    //创建对象的方法
    // new Class.newInstance Constructor.newInstance clone 反序列化 工厂方法
    public void newObject() {
        ObjectFunction a = new ObjectFunction();

        try {
            ObjectFunction b = ObjectFunction.class.newInstance();
            ObjectFunction b1 = (ObjectFunction) Class.forName("me.lm.basic.base.ObjectFunction").newInstance();
            ObjectFunction b2 = b1.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectFunction c = ObjectFunction.class.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ObjectFunction d = (ObjectFunction) a.clone();

        // ObjectInputStream read
    }

    public static void main(String[] args) {
        ObjectFunction o = new ObjectFunction();
        o.clone();
    }

    @Test
    public void test(){
        testField(Float.class);
    }
    public void testField(Class field) {

        if (field == String.class) {
            System.out.println("String");
        } else if (field == Float.class) {
            System.out.println("Float");
        } else if (field == Integer.class) {
            System.out.println("Integer");
        } else if (field == Boolean.class) {
            System.out.println("Boolean");
        } else {

        }
    }
}
