/**
 * @Author: WSS
 * @Date: 2019/3/7
 * @Description: 冒泡排序
 *  冒泡排序只会操作相邻的两个元素。每次对相邻的两个元素做大小比较，看是否满足大小关系。
 * 一次冒泡至少会让一个元素移动到最终位置(冒泡)
 *
 * 优化:设置标志位，若在某次循环结束后发现并没有元素交换，认为数据集已经有序，
 * 停止循环。
 *
 * 算法的执行效率
 * 最好情况
 * 数据集本身就是一个有序集合,O(n)
 *
 * 最坏情况
 * 数据集完全逆序,O(n^2)
 *
 * 平均情况O(n^2)
 *
 * 算法的内存消耗:O(1)，无需开辟新的空间，仅仅是原有数据做交换。
 * 冒泡排序是一个原地排序算法。
 *
 * 算法的稳定性
 * 冒泡排序由于相邻元素发生大小关系变换才会交换次序，所以当两个元素大小相等时，
 * 并不会改变其相对顺序。
 */
public class bubbleSort {
    public static void bubbleSort(int[] target){
        int size = target.length;

        if(size<=1){
            return;
        }
        for (int i = 0;i<size;i++){
            boolean flag = false;

            for (int j = 0;j<size-i-1;j++){
                if (target[j] > target[j+1]){
                    flag = true;
                    int temp = target[j+1];
                    target[j+1] = target[j];
                    target[j] = temp;
                }
            }

            if (!flag){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,5,6,1,2,3};
        bubbleSort(test);
        Tool.print(test);//输出：[1 2 3 4 5 6]
    }
}
