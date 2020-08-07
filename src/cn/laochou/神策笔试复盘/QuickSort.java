package cn.laochou.神策笔试复盘;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/5 0005 23:18
 * @Version: 1.0
 */
public class QuickSort {

    // 写一个标准快排
    public static void quickSort(int[] numbers) {
        quickSort(numbers, 0 , numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int start, int end) {
        int left = start;
        int right = end;
        int base = numbers[left];
        while (left < right) {
            while (left < right && numbers[right] >= base) {
                right--;
            }
            numbers[left] = numbers[right];
            while (left < right && numbers[left] < base) {
                left++;
            }
            numbers[right] = numbers[left];
        }
        numbers[left] = base;
        if(left > start) quickSort(numbers, start, left - 1);
        if(right < end) quickSort(numbers, right + 1, end);
    }

    // 快速k位排序
    public static double getKthNumber(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        // 向右位移1，相当与除法
        int midIndex = right >> 1;
        int index = -1;
        while (index < midIndex) {
            // 分区
            index = partition(numbers, left, right);
            if(index < midIndex) left = index + 1;
            else if(index > midIndex) right = index - 1;
            else break;
        }
        return numbers[index];
    }


    private static int partition(int[] numbers, int left, int right) {
        if(left > right) return -1;
        int pos = right;
        right--;
        while (left <= right) {
            while (left < pos && numbers[left] <= numbers[pos]) left++;
            while (right > left && numbers[right] > numbers[pos]) right--;
            if(left >= right) break;
            swap(numbers, left, right);
        }
        swap(numbers, left, right);
        return left;
    }


    private static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

}
