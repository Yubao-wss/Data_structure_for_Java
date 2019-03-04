package wss.Sequence;

import wss.SequenceArrayImpl;

import java.util.Arrays;

/**
 * @Author: WSS
 * @Date:
 * @Description:
 */
public class TestLinkedList {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        ll.add("wss");
        ll.add("java");
        ll.add("c++");
        ll.add("python");
        ll.add("PHP");
        System.out.println(ll);//输出：[wss,java,c++,python,PHP]
        //在索引1处插入一个元素
        ll.insert("new",1);
        System.out.println(ll);//输出：[wss,new,java,c++,python,PHP]
        //删除索引为2处的元素
        ll.delete(2);
        System.out.println(ll);//输出：[wss,new,c++,python,PHP]
        //元素PHP的位置
        System.out.println(ll.locate("PHP"));//输出：4

        SequenceLinkImpl sa = new SequenceLinkImpl();
        sa.add("wss");
        sa.add("java");
        sa.add("c++");
        sa.add("python");
        sa.add("PHP");
        System.out.println(Arrays.toString(sa.toArray()));//输出：[wss, java, c++, python, PHP]
        //获取索引1的元素内容
        Object o = sa.get(1);
        System.out.println(o);//输出：java
        //删除索引为2处的元素
        sa.remove(2);
        System.out.println(Arrays.toString(sa.toArray()));//输出：[wss, java, python, PHP]
        //链表是否存在PHP
        System.out.println(sa.contains("PHP"));//输出：true
    }
}
