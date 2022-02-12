package me.lm.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/15
 */
public class CustomBeanFactoryPostProcessor  implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("hello");
        System.out.println("test BeanFactoryPostProcessor");
    }
}
