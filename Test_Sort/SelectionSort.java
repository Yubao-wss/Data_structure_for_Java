/**
 * @Author: WSS
 * @Date:
 * @Description: 选择排序
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 * 稳定性:不稳定排序
 * eg:5 8 5 2 9
 */
public class SelectionSort {
    public static void selectionSort(int[] target){
        int n = target.length;
        if (n <= 1){
            return;
        }
        for (int i = 0;i < n-1;i++){
            int minIndex = i;
            for (int j = i+1;j < n;j++){
                if(target[j] < target[minIndex]){
                    minIndex = j;
                }
            }
            //此时minIndex对应的元素一定是当前未排序区间的最小值
            int temp = target[i];
            target[i] = target[minIndex];
            target[minIndex] = temp;
        }
    }


    //测试
    public static void main(String[] args) {
        int[] test = new int[]{4,2,5,1,6,7,9,8};
        selectionSort(test);
        Tool.print(test);//结果：[1 2 4 5 6 7 8 9]
    }
}
