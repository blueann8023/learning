package me.lm.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/18
 */
//@Service
public class AnnotationConfigApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

//        context.register(BeanConfig.class);
//        context.refresh();
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//        Color ioc = context.getBean("me.lm.spring.ioc.ColorFactoryBean", Color.class);

        Color bean1 = context.getBean(Color.class);
        System.out.println(bean1);
        context.close();
//        context.refresh();
    }

}
