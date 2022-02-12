package me.lm.algorithm.sort;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2021/12/9
 */
public abstract class AbstractMergeSort {

    protected Comparable[] aux;

    protected void merge(Comparable[] array, Comparable[] aux, int low, int middle, int high) {
        //init aux
        for (int i = low; i <= high; i++) {
            aux[i] = array[i];
        }
        int j = low, k = middle + 1;
        for (int i = low; i <= high; i++) {
            if (j > middle) {
                array[i] = aux[k++];
            } else if (k > high) {
                array[i] = aux[j++];
            } else if (Sort.less(aux[j], aux[k])) {
                array[i] = aux[j++];
            } else {
                array[i] = aux[k++];
            }
        }
    }
}
