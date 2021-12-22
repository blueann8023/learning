package me.lm.basic.algorithm.sort;

/**
 * Idea-将无序数组依次插入有序数组中
 * Des-迭代i，每次i同i+1位置对比直至插入，i前适当的位置,i前有序、i后不参与
 * A-随机数 1/4N^2 Comp & 1/4N^2 Exch
 * P-部分排序 接近线性
 * @author bule_ann
 * @since 2021/12/7
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i ; j > 0; j--) {
                if (Sort.less(array[j], array[j - 1])) {
                    Sort.exch(array,j,j-1);
                }else {
                    break;
                }
            }
        }
    }
}
