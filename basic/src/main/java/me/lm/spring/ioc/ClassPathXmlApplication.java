package me.lm.spring.ioc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class ClassPathXmlApplication {

    public static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplication.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean("hello"));
        System.out.println(context.getBean("beanConfig"));
    }
}
