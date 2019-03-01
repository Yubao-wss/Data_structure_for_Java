package wss.Sequence;

import wss.SequenceArrayImpl;

import java.util.Arrays;

/**
 * @Author: WSS
 * @Date:
 * @Description: 测试
 */
public class Test {
    public static void main(String[] args) {
        //测试SequenceArrayImpl
        Sequence sq1 = new SequenceArrayImpl();
        Object obj = new Object();
        sq1.add(2);
        obj = sq1.set(0,1);
        System.out.println(obj.toString());//结果：2
        System.out.println(sq1.get(0));//结果：1
        sq1.add(2);
        obj = sq1.get(1);
        System.out.println(obj.toString());//结果：2
        sq1.add(null);
        sq1.add(4);
        System.out.println(sq1.contains(null));//结果：true
        System.out.println(sq1.contains(4));//结果：true
        sq1.set(2,3);
        sq1.add(5);
        int size = sq1.size();
        System.out.println(size);//结果：5
        System.out.println(Arrays.toString(sq1.toArray()));//结果：[1, 2, 3, 4, 5]
        sq1.remove(2);
        System.out.println(Arrays.toString(sq1.toArray()));//结果：[1, 2, 4, 5]

    }
}
