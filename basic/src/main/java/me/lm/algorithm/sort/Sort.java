package me.lm.algorithm.sort;


/**
 * 排序接口
 * inplace 、stable、perform 、remark分析
 * @author bule_ann
 * @since 2021/12/7
 */
public interface Sort {

    void sort(Comparable[] array);

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void exch(Comparable[] array, int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

}

