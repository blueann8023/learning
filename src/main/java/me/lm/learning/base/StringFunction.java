package me.lm.learning.base;

import java.nio.charset.Charset;

public class StringFunction {

    //String  表示基于unicode 的utf-16格式的 字符串
    //immutable：final类，final char[]，final方法，final实现 + private
    //可共享 线程安全 存放在方法区中的常量池中
    public static void main(String[] args) {
        getByte();
        function();
    }

    //常用函数和实质 内存分析
    public static void function() {
        //创建
        String s1 = "aaa";
        String s2 = new String("aaa");
        String s3 = new String("aaa");
        String s4 = s1;
        String s5 = s2;
        System.out.println(s1.length());
        String s6 = s1+s2;
        s6.concat(s4);
        //substring 子串
        //valueOf
    }

    //字符 编码问题 Unicode(codepoint) Utf-16(1/2codeunit) char(codeunit) char[] byte[] Charset
    public static void getByte() {
        //冬
        System.out.println(String.valueOf(Character.toChars(0x2F81A)));
        String s = "\uD87E\uDC1A";

        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.getBytes().length);
        System.out.println(Charset.defaultCharset().aliases());
        System.out.println(s.getBytes(Charset.forName("UTF8")).length);
        System.out.println(s.getBytes(Charset.forName("UTF16")).length);
    }
    // equal hashcode 被重写

}
