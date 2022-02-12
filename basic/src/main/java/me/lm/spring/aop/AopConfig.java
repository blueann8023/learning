package me.lm.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/2/8
 */
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
