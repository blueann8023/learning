package me.lm.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/21
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
