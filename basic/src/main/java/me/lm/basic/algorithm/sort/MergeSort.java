package me.lm.basic.algorithm.sort;

/**
 * I-分治
 * D-递归-划分、排序、合并
 * A-NlgN C 6NlogN + N memory
 * P-优化内存复杂实践使用较少
 * P-数据量少后改为插入排序
 * P-稳定性
 *
 * @author bule_ann
 * @since 2021/12/7
 */
public class MergeSort extends AbstractMergeSort implements Sort {

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private void sort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        sort(array, aux, low, middle);
        sort(array, aux, middle + 1, high);
        merge(array, aux, low, middle, high);
    }

}
