package me.lm.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        System.out.println(context.getBean("hello").hashCode());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

    }
}
