import jdk.nashorn.tools.Shell;

import java.util.Arrays;

/**
 * @Author: WSS
 * @Date:
 * @Description: 测试各种排序算法效率
 */
public class Test {
    public static void main(String[] args) {
        //测试数组
        int[] test1 = Tool.creatArray(30000,0,30000);
        int[] test2 = Tool.creatArray(30000,0,30000);
        int[] test3 = Tool.creatArray(30000,0,30000);

        //冒泡排序
        long startBubble = System.currentTimeMillis();
        BubbleSort.bubbleSort(test1);
        BubbleSort.bubbleSort(test2);
        BubbleSort.bubbleSort(test3);
        long endBubble = System.currentTimeMillis();
        System.out.println("冒泡排序用时"+(endBubble-startBubble)+"ms");

        //新建数组
        test1 = Tool.creatArray(30000,0,30000);
        test2 = Tool.creatArray(30000,0,30000);
        test3 = Tool.creatArray(30000,0,30000);

        //直接插入排序
        long startInsert = System.currentTimeMillis();
        InsertSort.insertSort(test1);
        InsertSort.insertSort(test2);
        InsertSort.insertSort(test3);
        long endInsert = System.currentTimeMillis();
        System.out.println("直接插入排序用时"+(endInsert-startInsert)+"ms");

        //新建数组
        test1 = Tool.creatArray(30000,0,30000);
        test2 = Tool.creatArray(30000,0,30000);
        test3 = Tool.creatArray(30000,0,30000);

        //希尔排序
        long startShell = System.currentTimeMillis();
        ShellSort.shellSort(test1);
        ShellSort.shellSort(test2);
        ShellSort.shellSort(test3);
        long endShell = System.currentTimeMillis();
        System.out.println("希尔排序用时"+(endShell-startShell)+"ms");

        //新建数组
        test1 = Tool.creatArray(30000,0,30000);
        test2 = Tool.creatArray(30000,0,30000);
        test3 = Tool.creatArray(30000,0,30000);
        //选择排序
        long startSelection = System.currentTimeMillis();
        SelectionSort.selectionSort(test1);
        SelectionSort.selectionSort(test2);
        SelectionSort.selectionSort(test3);
        long endSelection = System.currentTimeMillis();
        System.out.println("选择排序用时"+(endSelection-startSelection)+"ms");

        //新建数组
        test1 = Tool.creatArray(30000,0,30000);
        test2 = Tool.creatArray(30000,0,30000);
        test3 = Tool.creatArray(30000,0,30000);
        //归并排序
        long startMergeSort = System.currentTimeMillis();
        MergeSort.mergeSort(test1);
        MergeSort.mergeSort(test2);
        MergeSort.mergeSort(test3);
        long endMergeSort = System.currentTimeMillis();
        System.out.println("归并排序用时"+(endMergeSort-startMergeSort)+"ms");

        //新建数组
        test1 = Tool.creatArray(30000,0,30000);
        test2 = Tool.creatArray(30000,0,30000);
        test3 = Tool.creatArray(30000,0,30000);

        //快速排序
        long startQuick = System.currentTimeMillis();
        QuickSort.quickSort(test1);
        QuickSort.quickSort(test2);
        QuickSort.quickSort(test3);
        long endQuick = System.currentTimeMillis();
        System.out.println("快速排序用时"+(endQuick-startQuick)+"ms");


        //结果：
        //冒泡排序用时4142ms
        //直接插入排序用时296ms
        //希尔排序用时16ms
        //选择排序用时1031ms
        //归并排序用时32ms
        //快速排序用时0ms


        System.out.println();
        //测试在待处理数组接近有序情况下的效率
        int n = 100000;
        int[] test4 = Tool.generateNearlySortedArray(n,10);

        startBubble = System.currentTimeMillis();
        BubbleSort.bubbleSort(Arrays.copyOf(test4,n));
        endBubble = System.currentTimeMillis();
        System.out.println("冒泡排序用时"+(endBubble-startBubble)+"ms");

        startInsert = System.currentTimeMillis();
        SelectionSort.selectionSort(Arrays.copyOf(test4,n));
        endInsert = System.currentTimeMillis();
        System.out.println("直接插入排序用时"+(endInsert-startInsert)+"ms");

        startShell = System.currentTimeMillis();
        ShellSort.shellSort(Arrays.copyOf(test4,n));
        endShell = System.currentTimeMillis();
        System.out.println("希尔排序用时"+(endShell-startShell)+"ms");

        startSelection = System.currentTimeMillis();
        SelectionSort.selectionSort(Arrays.copyOf(test4,n));
        endSelection = System.currentTimeMillis();
        System.out.println("选择排序用时"+(endSelection-startSelection)+"ms");

        startMergeSort = System.currentTimeMillis();
        MergeSort.mergeSort(Arrays.copyOf(test4,n));
        endMergeSort = System.currentTimeMillis();
        System.out.println("归并排序用时"+(endMergeSort-startMergeSort)+"ms");

        startQuick = System.currentTimeMillis();
        QuickSort.quickSort(Arrays.copyOf(test4,n));
        endQuick = System.currentTimeMillis();
        System.out.println("快速排序用时"+(endQuick-startQuick)+"ms");

        //结果：
        //冒泡排序用时1236ms
        //直接插入排序用时2513ms
        //希尔排序用时15ms
        //选择排序用时2528ms
        //归并排序用时16ms
        //快速排序用时0ms
    }
}

