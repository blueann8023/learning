package me.lm.spring.ioc;

import org.springframework.beans.factory.annotation.Value;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/22
 */
public class Person {
    @Value("11")
    private String name;

    @Value("#{11-1}")
    private Integer age;

    @Value("${nickName}")
    private String nickName;
}
