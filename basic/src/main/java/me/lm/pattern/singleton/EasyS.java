package me.lm.pattern.singleton;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/10
 */
public class EasyS {

    private static final EasyS instance = new EasyS();

    private EasyS() {
    }

    public EasyS getInstance() {
        return instance;
    }
}
