package me.lm.learning.algorithm;



//八大排序
public class Sorting {



    //Insertion Sort
    //将无序数组中的key，插入到有序数组中
    //worst:O(n^2)

    /**
     *
     * @param array
     */
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    //Merge Sort

    // 交换排序：冒泡+快速
    // 冒泡： 稳定
    public void bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 优化外层 追加交换flag
    public void bubble1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int change = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    change = 1;
                }
            }
            if (change == 0) {
                break;
            }
        }
    }

    //优化内层 记录最后交换位置
    public void bubble2(int[] array) {
        int k = array.length - 1, lastChangeIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int change = 0;
            for (int j = 0; j < k; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    change = 1;
                    lastChangeIndex = j;
                }
            }
            k = lastChangeIndex;
            if (change == 0) {
                break;
            }
        }
    }

    // 快速排序：挖坑填数+分治法
    public void quick(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public void quick(int[] array, int left, int right) {
        if (left < right) {
            int i = left, j = right, base = array[i];
            while (i != j) {
                while (i < j && array[j] >= base) {
                    j--;
                }
                while (i < j && array[i] <= base) {
                    i++;
                }
                if (i < j) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
            array[left] = array[i];
            array[i] = base;
            quick(array, left, i - 1);
            quick(array, i + 1, right);
        }
    }

    // 插入排序 ：直接插入 + 希尔


    // 希尔排序（分组插入排序，缩小增量排序）
    public void shell(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i - gap;
                int temp = array[i];
                while (j >= 0 && temp < array[j]) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = temp;
            }
        }
    }

    // 归并算法：分治法 + 合并有序数组，稳定
    public void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length, temp);
    }

    public void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left <= right)// length = 1
            return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid + 1, right, temp);
        merge(array, 0, mid, right, temp);//key
    }

    public void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        k = 0;
        while (left <= right) {
            array[left++] = temp[k++];
        }
    }

    //选择排序：简单选择 + 树形选择 + 堆排
    //简单选择：选择最小的后移动到数组最前
    public void simpleSelectSort(int[] array) {

    }

    //树形排序：
    public void treeSelectSort(int[] array) {

    }
    //堆排

}
