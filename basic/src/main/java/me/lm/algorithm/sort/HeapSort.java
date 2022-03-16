package me.lm.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * TODO
 * P in-place worst-case nlogn
 *
 * @author bule_ann
 * @since 2021/12/17
 */
public class HeapSort implements Sort {


    @Override
    public void sort(Comparable[] array) {
        // build heap

        // sort down-delete from heap
    }

    @Test
    public void a(){

        int[] heap = {3,2,3,1,2,4,5,5,6};
        findKthLargest(heap ,2);
    }
    public int findKthLargest(int[] nums, int k) {
        int[] heap = buildHeap(nums);
        int kMax = 0;
        Arrays.stream(heap).forEach(System.out::println);

        for (int i = 0; i < k; i++) {
            kMax = deleteMax(heap,heap.length-k-1);
        }
        return kMax;
    }

    private int deleteMax(int[] heap, int size) {
        int max = heap[1];
        heap[1] = heap[size];
        down(heap,  1,size);
        return max;
    }

    private void down(int[] heap, int i,int size ) {
        while (2 * i <= size) {
            int exchange = 2 * i;
            if (exchange < i && heap[exchange] < heap[exchange + 1]) {
                exchange++;
            }
            int temp = heap[exchange];
            heap[exchange / 2] = heap[exchange];
            heap[exchange] = temp;
            i = exchange;
        }
    }

    private int[] buildHeap(int[] nums) {
        int[] newArray = new int[nums.length + 1];
        for (int i = 1; i < newArray.length; i++) {
            newArray[i] = nums[i-1];
            up(newArray, i);
        }
        return newArray;
    }

    private void up(int[] newArray, int i) {
        while (i > 1 && newArray[i / 2] < newArray[i]) {
            int temp = newArray[i];
            newArray[i] = newArray[i / 2] ;
            newArray[i / 2] = temp;
            i = i / 2;
        }
    }
}
