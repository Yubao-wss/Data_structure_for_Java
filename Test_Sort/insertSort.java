/**
 * @Author: WSS
 * @Date:
 * @Description: 直接插入排序
 *
 * 直接插入排序:基于有序数组元素内容的插入得来
 * 核心思想:将待排序的数据分为两个区间，已排序区间与待排序区间。
 * 算法刚开始时，已排序空间有一个元素，在待排序空间中选择第一个元素与已排序空间的最后一个元素比较，若比已排序的最大元素大直接放入已排序空间最后一个位置，否则需要找到合适位置后进行插入。
 *
 * 时间复杂度
 * 最好O(n)
 * 最坏O(n^2)
 *
 * 原地排序算法
 *
 * 稳定性
 * 稳定性算法
 */
public class insertSort {
    public static void insertSort(int [] target){
        int size = target.length;
        if (size<=1){
            return;
        }

        for (int i = 1;i<size;i++){
            int temp = target[i];
            int j = i - 1;
            for (;j>=0;j--){
                if (target[j]>temp){
                    target[j+1] = target[j];
                }else {
                    break;
                }
            }
            target[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,1,7,3,0,6};
        insertSort(test);
        Tool.print(test);//输出：[0 1 2 3 6 7]
    }
}
