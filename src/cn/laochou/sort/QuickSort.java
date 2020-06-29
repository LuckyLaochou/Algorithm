package cn.laochou.sort;

import cn.laochou.day617.leetcode19.Solution;

import java.util.Arrays;
import java.util.logging.SocketHandler;

/**
 * 快排
 */
public class QuickSort {

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快排的思想主要是定基准，从后往前找。
     * @param array
     * @param start
     * @param end
     */
    private void quickSort(int[] array, int start, int end) {
        int left = start;
        int right = end;
        int base = array[left];
        while (left < right) {
            while (left < right && array[right] >= base) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < base) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = base;
        if(left > start) {
            quickSort(array, start, left - 1);
        }
        if(right < end) {
            quickSort(array, right + 1, end);
        }
    }


    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.quickSort(new int[] {11, 2, 5, 3, 1, 90, 80, 100});
    }

}
