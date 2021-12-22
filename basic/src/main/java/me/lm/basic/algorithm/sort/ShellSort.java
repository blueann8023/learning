package me.lm.basic.algorithm.sort;

/**
 * A-一定规律递减h（3h+1）， 在insertion sort上把移动步长变为h
 * V-h数组的有序
 * P-多了循环但效率高、部分排序接近线性、无精确数学模型
 * P-算法简单、一定场景可以击败很多算法、最佳h递减值找寻中
 * @author bule_ann
 * @since 2021/12/8
 */
public class ShellSort implements Sort {
    @Override
    public void sort(Comparable[] array) {
        int h = 3;
        for (int i = h; i < array.length; i++) {
            for (int j = i; j > 0; j -= h) {
                if (Sort.less(array[j], array[j - h])) {
                    Sort.exch(array, j, h);
                }
            }
        }
    }
}
