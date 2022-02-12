package me.lm.spring.ioc;

import me.lm.jvm.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/20
 */
@Configuration
//@Import(ColorFactoryBean.class)
//@ComponentScan
public class Config {
    @Bean
    public Hello hello(){
        return new Hello();
    }
    @Bean("me.lm.spring.ioc.A")
    public A a(){
        return new A();
    }

//    @Bean(initMethod = "init",destroyMethod = "destroy")
    @Bean
    public Color color(){
        return  new Color();
    }

}
