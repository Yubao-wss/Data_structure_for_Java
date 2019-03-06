package wss.Sequence;

import java.util.Arrays;

/**
 * @Author: WSS
 * @Date:
 * @Description: 测试双链表
 */
public class TestDoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedListImpl newDLL = new DoubleLinkedListImpl();
        newDLL.add(1);
        newDLL.add(2);
        newDLL.add(3);
        newDLL.remove(2);
        System.out.println(Arrays.toString(newDLL.toArray()));//输出：[1, 2]
        System.out.println(newDLL.contains(1));//输出：true
        System.out.println(newDLL.get(1));//输出：2
        newDLL.set(1,5);
        System.out.println(Arrays.toString(newDLL.toArray()));//输出：[1, 5]
        newDLL.clear();
        System.out.println(newDLL.size());//输出：0
    }
}
