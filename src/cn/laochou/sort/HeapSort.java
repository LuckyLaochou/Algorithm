package cn.laochou.sort;

import java.util.Arrays;

/**
 * 堆排序（主要是先要构造最大堆，如何进行堆排）
 */
public class HeapSort {

    public void heapSort(int[] array) {
        buildHeap(array);
        System.out.println(Arrays.toString(array));
        // 进行树化
        int size = array.length - 1;
        while (size > 0) {
            swap(array, 0, size);
            size--;
            heapify(array, 0, size);
        }
        System.out.println(Arrays.toString(array));
    }

    private void buildHeap(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            while (array[fatherIndex] < array[currentIndex]) {
                // need change
                swap(array, fatherIndex, currentIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }


    private void heapify(int[] array, int index, int size) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int maxIndex = index;
        while (leftIndex <= size) {
            // 我们需要找到最大堆
            if (array[leftIndex] < array[rightIndex] && rightIndex <= size) {
                maxIndex = rightIndex;
            }else {
                maxIndex = leftIndex;
            }
            if (array[index] >= array[maxIndex]) {
                break;
            }
            swap(array, maxIndex, index);
            index = maxIndex;
            leftIndex = index * 2 + 1;
            rightIndex = index * 2 + 2;
        }
    }


    private void swap(int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        sort.heapSort(new int[] {11, 2, 5, 3, 1, 90, 80, 100});
    }
}
