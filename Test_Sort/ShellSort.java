/**
 * @Author: WSS
 * @Date:
 * @Description: 希尔排序（对于插入排序交换部分的优化，step=1时，即是直接插入排序）
 * 原先找到插入位置后，元素是一个一个向后搬移，损耗较大。
 * 能否在搬移元素时多走几步，即一次多搬移几个元素。
 *
 * 原先:一次走一步
 * 一次多走几步
 *
 * 空间复杂度:O(1)
 * 稳定性:稳定
 */
public class ShellSort {
    public static void shellSort(int[] target){
        int n = target.length;
        if (n <= 1){
            return;
        }else{
            int step = n/2;
            while (step >= 1){
                for (int i = step;i < n;i++){
                    int value = target[i];
                    int j = i-step;
                    for (;j>=0;j-=step){
                        if (target[j] > value){
                            target[j+step] = target[j];
                        }else {
                            break;
                        }
                    }
                    target[j+step] = value;
                }
                step /= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,6,3,2,7,5,8,7};
        shellSort(test);
        Tool.print(test);//结果：[1 2 3 5 6 7 7 8]
    }
}
