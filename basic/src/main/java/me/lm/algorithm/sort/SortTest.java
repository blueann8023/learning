package me.lm.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2021/12/7
 */
public class SortTest {

    @Test
    public void testSelectionSort(){
        Comparable[] array = randomComparables(10000);
        new SelectionSort().sort(array);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void testInsertionSort(){
        Comparable[] array = randomComparables(10000);
        new InsertionSort().sort(array);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void testMergeSort(){
        Comparable[] array = randomComparables(100);
        new MergeSort().sort(array);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void testBottomUpMergeSort(){
        Comparable[] array = randomComparables(100);
        new BottomUpMergeSort().sort(array);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void testQuickSort(){
        Comparable[] array = randomComparables(100);
        new QuickSort().sort(array);
        Assert.assertTrue(isSorted(array));
    }

    public static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (Sort.less(array[i], array[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static Comparable[] randomComparables(int size){
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return  array;
    }


}
