package me.lm.spring.ioc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/21
 */
public class Color implements InitializingBean, DisposableBean {
    private String name;

    public Color() {
        System.out.println("constructor");
    }
//    @PostConstruct
    public void init() {
        System.out.println("init");
    }


//    @PreDestroy
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
}
