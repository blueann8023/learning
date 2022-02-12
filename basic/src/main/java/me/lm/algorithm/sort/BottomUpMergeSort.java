package me.lm.algorithm.sort;

/**
 * Idea-自下而上的合并、消除递归调用
 *
 * @author bule_ann
 * @since 2021/12/9
 */
public class BottomUpMergeSort extends AbstractMergeSort implements Sort {

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        for (int size = 1; size < array.length; size += size) {
            for (int low = 0; low < array.length - size; low += size*2) {
                merge(array, aux, low, low + size - 1, Math.min(low + 2 * size - 1, array.length - 1));
            }
        }
    }
}
