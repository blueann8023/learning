package me.lm.algorithm.sort;

/**
 * I-挖坑选择填数、选择最小的后移动到数组最前
 * D-迭代i，找到i后最小数与i交换 ，i前有序，i后没有比i前小的数据
 * A-N^2/2 Comp + N Exch
 * P-Comp平方、即使完全排序也要平方级的比较
 *
 * @author bule_ann
 * @since 2021/12/7
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(Comparable[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (Sort.less(array[j], array[min])) {
                    min = j;
                }
            }
            Sort.exch(array, i, min);
        }
    }

}
