import java.util.Random;

/**
 * @Author: WSS
 * @Date:
 * @Description: 工具类
 */
public class Tool {

    //打印数组
    public static void print(int[] target){
        System.out.print("[");
        for (int i = 0;i < target.length;i++){
            System.out.print(target[i]);
            if(i < target.length-1){
                System.out.print(" ");
            }

        }
        System.out.print("]");
    }

    /***
     * 自定义一个随机数组
     * @param size 数组长度
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static int[] creatArray(int size,int min,int max){
        Random random = new Random();
        int[] newArray = new int[size];
        for (int i = 0;i < size;i++){
            int number = min+random.nextInt(max+1);
            newArray[i] = number;
        }
        return newArray;
    }

    /***
     * 生成一个近似有序数组
     * @param n 要生成的数据大小
     * @param switchTimes 交换次数
     * @return
     */
    public static int[] generateNearlySortedArray(int n,int switchTimes){
        int[] result = new int[n];
        //先构造一个完全有序的数据集
        for (int i = 0;i<n;i++){
            result[i] = i;
        }
        for(int i = 0;i < switchTimes;i++){
            //随机选取范围内的两个索引下标进行交换
            Random random = new Random();
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            int temp = result[a];
            result[a] = result[b];
            result[b] = temp;
        }
        return result;
    }
}
