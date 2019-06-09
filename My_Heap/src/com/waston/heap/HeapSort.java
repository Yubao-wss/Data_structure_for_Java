package src.com.waston.heap;

import java.util.Random;

/**
 * @Description: 堆排序
 * @Author: Waston
 * @Date: 2019/6/9 10:24
 */
public class HeapSort {

    public static void heapSort1(Integer [] arr){
        // 将数组调整成堆
        Heap<Integer> heap = new Heap<>(arr);
        // 从最后一个位置开始
        for (int i = arr.length - 1;i >= 0;i--) {
            arr[i] = heap.extractMax();
        }
    }

    /**
     * 原地堆排序
     * @param arr
     */
    public static void heapSort2(Integer[] arr){
        int length = arr.length;
        // arr -> 堆
        for (int i = (length - 1 - 1) / 2;i >= 0;i--) {
            siftDown(arr,length,i);
        }
        // 依次将最大值换到数组末尾
        for (int i = length - 1;i >= 0;i--) {
            swap(arr,0,i);
            siftDown(arr,i,0);
        }
    }
    /**
     * 交换
     * @param arr
     * @param indexA
     * @param indexB
     */
    private static void swap(Integer[] arr,int indexA,int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    private static void siftDown(Integer[] arr,int n,int k){
        while (2*k+1 < n) {
            int j = 2*k+1;
            // 取出左右孩子的最大值
            if (j + 1 < n) {
                if (arr[j].compareTo(arr[j+1]) < 0) {
                    j++;
                }
            }
            // arr[j] 存放了左右两个孩子的最大值
            if (arr[k] > arr[j])
                break;
            swap(arr,k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{7,6,5,4,3,2,1,2,1};
        heapSort1(ints);

    }
}
