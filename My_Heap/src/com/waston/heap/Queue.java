package src.com.waston.heap;

/**
 * @Description: 队列
 * @Author: Waston
 * @Date: 2019/6/9 11:34
 */
public interface Queue<E extends Comparable<E>> {
    void enqueue(E e);
    E dequeue();
    E peek();
    int getSize();
    boolean isEmpty();
}
