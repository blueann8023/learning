package me.lm.spring.ioc;

import org.springframework.core.type.AnnotationMetadata;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/21
 */
public class CustomImportSelector implements org.springframework.context.annotation.ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
