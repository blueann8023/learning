package me.lm.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {

    public static final Logger logger = LoggerFactory.getLogger(XmlApplication.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(context.getBean("hello").hashCode());
        System.out.println(context.getBeanDefinitionNames());
    }
}
