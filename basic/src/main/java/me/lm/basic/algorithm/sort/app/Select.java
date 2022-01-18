package me.lm.basic.algorithm.sort.app;

/**
 * 选择N个元素(流)中的TOP M
 *
 * @author bule_ann
 * @since 2021/12/17
 */
public interface Select {

    Comparable[] topM(Comparable[] array, int M);

}
