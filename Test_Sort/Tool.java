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
}
