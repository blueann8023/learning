package me.lm.algorithm.sort;

/**
 * I- 先排在递归、自上往下
 * V- 分区点左小右大
 * D-
 * P- 分区点的选择影响排序性能、最好shuffle
 *
 * @author bule_ann
 * @since 2021/12/13
 */
public class QuickSort implements Sort {
    @Override
    public void sort(Comparable[] array) {
        // 很重要
        //shuffle();
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(array, low, high);
        sort(array, low, p - 1);
        sort(array, p + 1, high);
    }

    private int partition(Comparable[] array, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (Sort.less(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }
            while (Sort.less(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Sort.exch(array, i, j);
        }
        Sort.exch(array, low, j);
        return j;
    }
}
